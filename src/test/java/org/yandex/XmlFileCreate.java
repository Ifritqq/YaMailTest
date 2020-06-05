package org.yandex;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XmlFileCreate {
    public static String resultTxt;

    static {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if (Test.class.desiredAssertionStatus()) {
            resultTxt = "passed";
        } else {
            resultTxt = "failed";
        }

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element test = doc.createElement("test");
            doc.appendChild(test);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("yandex"));
            test.appendChild(name);

            Element datethis = doc.createElement("date");
            datethis.appendChild(doc.createTextNode(dateFormat.format(date)));
            test.appendChild(datethis);

            Element resultThis = doc.createElement("result");
            resultThis.appendChild(doc.createTextNode(resultTxt));
            test.appendChild(resultThis);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/test/results/result.xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

