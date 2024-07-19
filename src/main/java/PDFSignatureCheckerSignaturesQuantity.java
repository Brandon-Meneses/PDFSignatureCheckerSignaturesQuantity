
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFSignatureCheckerSignaturesQuantity {

    public static void printSignatureInfo(File pdfFile) {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            List<PDSignature> signatures = document.getSignatureDictionaries();
            if (signatures.isEmpty()) {
                System.out.println("El documento no tiene firmas digitales.");
            } else {
                System.out.println("El documento tiene " + signatures.size() + " firmas digitales.");
                for (int i = 0; i < signatures.size(); i++) {
                    PDSignature signature = signatures.get(i);
                    System.out.println("Firma " + (i + 1) + ":");
                    System.out.println("  Nombre del firmante: " + signature.getName());
                    System.out.println("  Fecha de la firma: " + signature.getSignDate());
                    System.out.println("  Contacto del firmante: " + signature.getContactInfo());
                    System.out.println("  Razón de la firma: " + signature.getReason());
                    System.out.println("  Ubicación de la firma: " + signature.getLocation());
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("/Ruta/Al/Archivo.pdf");
        printSignatureInfo(file);
    }
}
