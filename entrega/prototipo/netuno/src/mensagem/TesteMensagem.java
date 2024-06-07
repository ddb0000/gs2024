package mensagem;

import java.util.Scanner;

public class TesteMensagem {
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int op;
        
        System.out.println("fale um numero - 1: Usuario e 2: Admin");
        
        op = sc.nextInt();
      
                    switch (op) {
                        case 1:
                            System.out.println("Digite seu nome:");
                            Cliente cliente = new Cliente(null, null, null);
                            cliente.setNome(sc.next() + sc.nextLine());
                            
                            System.out.println("Digite seu email" );
                            cliente.setEmail(sc.next() + sc.nextLine());
                            
                            System.out.println("Digite sua mensagem" );
                            Mensagem msg = new Mensagem();
                            msg.setMensagem(sc.next() + sc.nextLine());
                            
                            System.out.println("Mensagem salva com sucesso!!");
                           
                            System.out.println("Mensagem: [ " + msg.getMensagem() + " ]");
                            
                            break;
                            
                        case 2:
                            System.out.println("Seja bem vindo - Voce te, 9 mensagens novas");
                            
                            break;
                        case 0:
                            System.out.println("Finalizando o programa");
                        default:
                            System.out.println("Opção inválida");
                    
                }while(op != 0);

                sc.close();

            }
    
}
