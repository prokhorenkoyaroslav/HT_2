package com.example.ht_2;

import com.example.ht_2.pages.PLogin;
import com.example.ht_2.util.XmlParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.HashMap;

public class GitHubTest extends BaseTest {

    private final PLogin pLogin = new PLogin();

    private static final String REPOSITORY_NAME = "prokhorenkoyaroslav/HT_2";

    private static final String DEPENDENCY_ARTIFACTID   = "testng";
    private static final String DEPENDENCY_VERSION      = "7.4.0";


    @Test
    public void testGitHubLoginAndSearch() {
        var text = pLogin
                .loginUser()
                .searchRepository(REPOSITORY_NAME)
                .openFile("pom.xml")
                .getContent().text();

        HashMap<String, String> dependencies = getDependencies(text);

        Assert.assertEquals(dependencies.get(DEPENDENCY_ARTIFACTID), DEPENDENCY_VERSION);
    }

    private HashMap<String, String> getDependencies(String xml) {
        NodeList dependency = XmlParser.loadXMLFromString(xml).getElementsByTagName("dependency");
        HashMap<String, String> dependencies = new HashMap<>();
        for (int i = 0; i < dependency.getLength(); i++) {
            Element item = (Element) dependency.item(i);
            NodeList versionList = item.getElementsByTagName("version");
            NodeList nameList = item.getElementsByTagName("artifactId");

            dependencies.put(nameList.item(0).getTextContent(), versionList.item(0).getTextContent());
        }

        dependencies.forEach((e, a) -> logger.info(e + " " + a));

        return dependencies;
    }
}
