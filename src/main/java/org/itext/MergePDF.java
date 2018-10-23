package org.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class MergePDF {

    //public static final String dest = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\1000";
    //public static final String dest = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\12";
    //public static final String dest = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs\\69\\split";
    public static final String dest = "C:\\Altisource\\Virtual Box-Data\\shared\\Altisource\\origination-docs" +
            "\\image_test";

    public static void main(String[] args) {

        File folder = new File(dest);
        File[] files = folder.listFiles();

        Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
        OutputStream outputStream = null;
        try {

            outputStream = new FileOutputStream(dest+"\\69_merged.pdf");
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            //writer.setFullCompression();
            document.open();
            PdfContentByte cb = writer.getDirectContent();

            for(File aFile : files) {
                if(aFile.getName().toUpperCase().endsWith("PDF")) {
                    PdfReader reader = new PdfReader(new FileInputStream(aFile));
                    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                        document.newPage();
                        PdfImportedPage page = writer.getImportedPage(reader, i);
                        cb.addTemplate(page, 0, 0);

                    }
                } else if(aFile.getName().toUpperCase().endsWith("PNG")) {

                    Image image = Image.getInstance(aFile.getAbsolutePath());
                    scaleImage(image, document);
                    document.newPage();
                    document.setPageSize(image);
                    image.setAbsolutePosition(0, 0);
                    cb.addImage(image);
                }
            }

            outputStream.flush();
            document.close();
            outputStream.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void scaleImage(Image image, Document document) {
        float scalar = 0.0F;
        float xScalar = document.getPageSize().getWidth() / image.getWidth();
        float yScalar = document.getPageSize().getHeight() / image.getHeight();
        if (xScalar > yScalar) {
            scalar = yScalar * 100.0F;
        } else {
            scalar = xScalar * 100.0F;
        }

        image.scalePercent(scalar);
    }

}
