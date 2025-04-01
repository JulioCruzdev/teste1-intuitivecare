import java.io.*;
import java.util.zip.*;

public class CompactarArquivos {
    public static void main(String[] args) {

        String arquivoZip = "arquivos_compactados.zip";
        String[] arquivos = {"Anexo1.pdf", "Anexo2.pdf"};

        try {
            FileOutputStream fos = new FileOutputStream(arquivoZip);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            for (String arquivo : arquivos) {

                FileInputStream fis = new FileInputStream(arquivo);

                ZipEntry zipEntry = new ZipEntry(arquivo);
                zipOut.putNextEntry(zipEntry);


                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, len);
                }

                fis.close();
            }

            zipOut.close();

            System.out.println("Arquivos compactados com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}