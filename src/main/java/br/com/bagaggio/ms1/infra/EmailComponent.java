package br.com.bagaggio.ms1.infra;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailComponent {

    public static void sendEmail(String from, String to, String message, String cc) {
        String url = "https://ms-email.bagaggio.com.br/ms-email/sent"; // Substitua pelo URL real do serviço de email

        // Parâmetros do corpo da requisição
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("emailFrom", from)); // Endereço de email do destinatário
        params.add(new BasicNameValuePair("emailTo", to));
        params.add(new BasicNameValuePair("message", message));
        params.add(new BasicNameValuePair("cc", cc));
        params.add(new BasicNameValuePair("subject", "Email Test"));
        params.add(new BasicNameValuePair("html", "Conteúdo do Email"));

        // Cria um objeto HttpPost com a URL do serviço de email
        HttpPost httpPost = new HttpPost(url);

        // Adiciona os parâmetros ao corpo da requisição
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Cria um cliente HTTP para executar a requisição
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Envia a requisição e obtém a resposta
            HttpResponse response = httpClient.execute(httpPost);


            // Imprime o código de status da resposta
            System.out.println("Código de Status: " + response.getStatusLine().getStatusCode());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            // Trata erros de IO, como falha na conexão
        }
    }

}
