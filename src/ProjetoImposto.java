import java.util.Scanner;

public class ProjetoImposto {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        // Informações de entradas do usuário
        System.out.println("Informe a sua renda anual com salário: ");
        double rendaAnualSalario = scan.nextDouble();   
       
        System.out.println("Informe a sua renda anual com prestação de serviços:");
        double rendaServiço = scan.nextDouble();   
       
        System.out.println("Informe o valor da usa renda com ganho do capital (imóveis, ações, etc.): ");
        double ganhoCapital = scan.nextDouble();   
       
        System.out.println("Informe os seus gastos médicos ");
        double gastosMedicos = scan.nextDouble();   
        
       System.out.println("Informe os seus gastos educacionais");
        double gastosEducacionais = scan.nextDouble(); 

       // Cálculo do imposto sobre salário
        double impostoSalario = 0.0;

        if (rendaAnualSalario < 36000) {
            impostoSalario = 0.0; // Isento
        } else if (rendaAnualSalario >= 36000 && rendaAnualSalario < 
        60000) {
            impostoSalario = rendaAnualSalario * 0.10;// 10% de imposto
        } else {
            impostoSalario = rendaAnualSalario * 0.20;// 20% de imposto
        }
        
        // Cálculo do imposto sobre serviços
        double impostoServiço = rendaServiço * 0.15;
       
        // Cálculo do imposto sobre ganho de capital
        double impostoCapital = ganhoCapital * 0.20;
       
        // Imposto bruto total (antes das deduções)
        double impostoBruto = impostoSalario + impostoServiço + impostoCapital;
       
         // Soma dos gastos médicos e educacionais para deduções
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;

        // Limite de dedução (30% do imposto bruto)
        double limiteAbatimento = impostoBruto * 0.30; 
       
        // Abatimento efetivo (o menor valor entre os gastos dedutíveis e o limite de dedução)
        double abatimentoEfetivo  = Math.min(gastosDedutiveis, limiteAbatimento);
        
         // Imposto final a ser pago (imposto bruto - abatimento)
        double impostoLiquido = impostoBruto - abatimentoEfetivo;
      
        
      /////////////////////////////////Relatório do Imposto////////////////////////////////////  

        System.out.println("--------------------------------------");
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("--------------------------------------");
       
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.println("--------------------------------------");
       
        System.out.printf("imposto sobre salário: R$%.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços; R$%.2f\n", impostoServiço);
        System.out.printf("imposto sobre ganho de capital: R$%.2f\n", impostoCapital);
        
        System.out.println("**************************************");
        System.out.println(" DEDUÇÕES:");
        System.out.println("**************************************");
        System.out.printf("Máximo dedutível: R$%.2f\n", limiteAbatimento);
        System.out.printf("Gastos dedutíveis: R$%.2f\n", gastosDedutiveis);
        System.out.println("--------------------------------------");
       
        System.out.println("* RESUMO:");
        System.out.printf("imposto bruto total: R$%.2f\n", impostoBruto);
        System.out.printf("abatimento  R$%.2f\n", abatimentoEfetivo);
        System.out.printf("imposto líquido a pagar: R$%.2f\n", impostoLiquido);
        System.out.println("--------------------------------------");

        scan.close();
    }
}
 