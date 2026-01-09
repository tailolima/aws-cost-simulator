import java.util.Scanner;

/**
 * Simulador de Custos da AWS - Região sa-east-1 (Brasil)
 * 
 * Este programa ajuda estudantes a estimar o custo mensal de hospedar
 * um site estático na AWS usando S3 + CloudFront.
 * 
 * @author George Tailo Lima da Conceição
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("☁️ Bem-vindo ao Simulador de Custos da AWS!");
        System.out.println("Região utilizada: sa-east-1 (São Paulo, Brasil)\n");

        // Pergunta dados ao usuário
        System.out.print("➡️ Tamanho do seu site (em GB): ");
        double storageGB = scanner.nextDouble();

        System.out.print("➡️ Tráfego mensal esperado (em GB): ");
        double trafficGB = scanner.nextDouble();

        // Preços reais da AWS - região sa-east-1 (junho/2024)
        final double STORAGE_PRICE = 0.036; // USD por GB/mês
        final double TRAFFIC_PRICE = 0.15;  // USD por GB de saída

        // Cálculo
        double storageCost = storageGB * STORAGE_PRICE;
        double trafficCost = trafficGB * TRAFFIC_PRICE;
        double totalCost = storageCost + trafficCost;

        // Resultado formatado
        System.out.println("\n📊 Estimativa de custo mensal na AWS (S3 + CloudFront):");
        System.out.printf("• Armazenamento (%.1f GB): US$ %.2f\n", storageGB, storageCost);
        System.out.printf("• Tráfego de saída (%.1f GB): US$ %.2f\n", trafficGB, trafficCost);
        System.out.printf("• Total estimado: US$ %.2f\n", totalCost);

        // Dicas personalizadas
        if (totalCost < 0.50) {
            System.out.println("\n💡 Dica: Seu custo é muito baixo! Provavelmente está dentro do Free Tier.");
        } else if (totalCost < 5.00) {
            System.out.println("\n💡 Dica: Custo acessível para projetos pessoais. Considere usar cache para reduzir tráfego.");
        } else {
            System.out.println("\n💡 Dica: Para sites com alto tráfego, avalie CDN ou otimização de imagens.");
        }

        // Comparação opcional com EUA (bônus!)
        double totalUS = (storageGB * 0.023) + (trafficGB * 0.09);
        System.out.printf("\n🌎 Comparação com região us-east-1 (EUA): US$ %.2f\n", totalUS);
        if (totalCost > totalUS) {
            System.out.println("   → Hospedar nos EUA é mais barato, mas a latência pode ser maior para usuários no Brasil.");
        }

        scanner.close();
    }
}
