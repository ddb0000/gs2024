package netuno;

public class Main {
	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <id>");
            System.exit(1);
        }

        int automatoId = Integer.parseInt(args[0]);
        String serverUrl = "http://127.0.0.1:8000/api";  // URL do servidor local

        // Registra o automato se ainda não existir
        System.out.println("Registrando o automato...");
        // Implementação para fazer o POST para o servidor e verificar se foi registrado com sucesso

        AutomatoNetuno automato = new AutomatoNetuno(automatoId, serverUrl);
        automato.iniciar();
	}
}
