package src;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BuildReporter {
    public static void main(String[] args) {
        // Coleta a data e hora do momento exato do build.
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        // Estrutura o HTML que sera o artefato de entrega.
        String htmlContent = "<!DOCTYPE html>\n"
                + "<html lang=\"pt-BR\">\n"
                + "<head>\n"
                + "  <meta charset=\"UTF-8\">\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "  <title>Pipeline de CI/CD - CEUB</title>\n"
                + "  <style>\n"
                + "    body { font-family: Arial, sans-serif; margin: 0; background: #f4f6f8; color: #1f2937; }\n"
                + "    .container { max-width: 860px; margin: 40px auto; background: #ffffff; border-radius: 14px; box-shadow: 0 10px 30px rgba(0,0,0,0.08); overflow: hidden; }\n"
                + "    .header { background: linear-gradient(120deg, #0b3d91, #1464d2); color: #fff; padding: 28px; }\n"
                + "    .header h1 { margin: 0; font-size: 28px; }\n"
                + "    .header p { margin: 8px 0 0; opacity: 0.95; }\n"
                + "    .content { padding: 28px; line-height: 1.55; }\n"
                + "    .status { display: inline-block; margin: 14px 0; padding: 10px 16px; border-radius: 999px; background: #e8f7ec; color: #146c2e; font-weight: bold; }\n"
                + "    .card { margin-top: 20px; padding: 18px; border: 1px solid #e5e7eb; border-radius: 12px; background: #fafafa; }\n"
                + "    .footer { font-size: 13px; color: #6b7280; padding: 20px 28px 28px; }\n"
                + "  </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "  <div class=\"container\">\n"
                + "    <div class=\"header\">\n"
                + "      <h1>Pipeline de CI/CD - CEUB</h1>\n"
                + "      <p>Build and Deploy Automatizados</p>\n"
                + "    </div>\n"
                + "    <div class=\"content\">\n"
                + "      <h2>Status do Ambiente</h2>\n"
                + "      <div class=\"status\">PRODUCAO ONLINE</div>\n"
                + "      <div class=\"card\">\n"
                + "        <p><strong>Tecnologia de Build:</strong> Java Compiler and Executor</p>\n"
                + "        <p><strong>Orquestrador:</strong> GitHub Actions Pipeline</p>\n"
                + "        <p><strong>Data de Construcao:</strong> " + timestamp + " UTC</p>\n"
                + "      </div>\n"
                + "      <p>Oficina de Gerencia de Configuracao - Pos-Graduacao CEUB</p>\n"
                + "    </div>\n"
                + "    <div class=\"footer\">Gerencia de Configuracao e Automacao de Software</div>\n"
                + "  </div>\n"
                + "</body>\n"
                + "</html>\n";

        // Grava o arquivo index.html que sera servido no GitHub Pages.
        try (FileWriter writer = new FileWriter("index.html")) {
            writer.write(htmlContent);
            System.out.println("Sucesso: Relatorio de Build 'index.html' gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro critico ao gerar o relatorio: " + e.getMessage());
            System.exit(1); // Forca falha no processo de build.
        }
    }
}
