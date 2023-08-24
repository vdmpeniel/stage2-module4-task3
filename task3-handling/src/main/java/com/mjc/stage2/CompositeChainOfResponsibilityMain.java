package com.mjc.stage2;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.parser.AbstractTextParser;
import com.mjc.stage2.parser.ChainParserBuilder;
import com.mjc.stage2.reader.DataReader;
import com.mjc.stage2.reader.impl.DataReaderImpl;
import com.mjc.stage2.validator.FileValidator;
import com.mjc.stage2.validator.impl.FileValidatorImpl;

import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;

public class CompositeChainOfResponsibilityMain {
    private static String PATH = "data/textdata.txt";

    public static void main(String[] args) {
        try {
            System.out.println("Starting Text Parser");
            String text = readTextData();

            AbstractTextParser parser = new ChainParserBuilder().build();
            AbstractTextComponent component = new TextComponent(TextComponentType.WORD);
            parser.parse(component, text);

            System.out.println(component.operation());

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static String readTextData() throws Exception{
        String resourcePath = getResourcePath(PATH);
        DataReader dataReader = new DataReaderImpl();
        return dataReader.readFile(resourcePath);
    }

    private static String getResourcePath(String path) throws Exception{
        URL URLPath = CompositeChainOfResponsibilityMain.class
            .getClassLoader()
            .getResource(path);
        System.out.println(URLPath.toURI().getPath());
        return URLDecoder.decode(URLPath.toURI().getRawPath(), "UTF-8").substring(1);
    }
}
