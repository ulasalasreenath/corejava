package org.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.FileOutputStream;
import java.io.IOException;

public class SplitPDF {


    //public static final String path = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\1000 pages doc.pdf";
    //public static final String path1 = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\1000\\1000_pageNo.pdf";
    public static final String path = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\69\\69.pdf";
    public static final String path1 = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\69\\69_pageNo.pdf";

    public static void main(String[] args) {

        try {
            PdfReader reader = new PdfReader(path);
            int noOfPages = reader.getNumberOfPages();
            for(int i = 0; i < noOfPages;) {

                String pdf = path1.replace("pageNo", Integer.toString(i + 1));
                Document document = new Document(reader.getPageSizeWithRotation(1));
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(pdf));
                document.open();
                PdfImportedPage page = writer.getImportedPage(reader, ++i);
                writer.addPage(page);
                document.close();
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
