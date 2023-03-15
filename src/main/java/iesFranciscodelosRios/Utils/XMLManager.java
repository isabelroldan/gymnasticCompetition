package iesFranciscodelosRios.Utils;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLManager {

    public static <T> boolean writeXML(T c, String fichero) {
        boolean result = false;
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(c.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.marshal(c, new File(fichero));
            result = true;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> T readXML(T c, String fichero) {
        File file=new File(fichero);
        T result = c;
        if(file.exists()){
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(result.getClass());
                Unmarshaller m = context.createUnmarshaller();
                result= (T) m.unmarshal(new File(fichero));
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
