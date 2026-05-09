public class Aplicacao {

    public static void main(String[] args) {
        System.out.println("=== Tarefa 1: Testes preliminares da Fila ===");
        Fila<Character> filaNome = new Fila<>();
        String nome = "Yan Resende";

        // Enfileirando os caracteres do nome um a um
        for (char c : nome.toCharArray()) {
            filaNome.enfileirar(c);
        }

        System.out.println("Fila de caracteres criada com o nome: " + nome);
        System.out.println("Tamanho atual da fila: " + filaNome.tamanho());

        // Contando ocorrências de um caractere específico
        char caractereAlvo = 'e';
        int ocorrencias = filaNome.contarOcorrencias(caractereAlvo);
        System.out.println("Ocorrências da letra '" + caractereAlvo + "': " + ocorrencias);

        // Testando o desenfileirar
        if (!filaNome.vazia()) {
            char removido = filaNome.desenfileirar();
            System.out.println("Primeiro caractere desenfileirado: " + removido);
            System.out.println("Tamanho da fila após desenfileirar: " + filaNome.tamanho());
        }

        System.out.println("\n=== Tarefa 3: Teste extrairLote ===");
        Fila<Character> loteExtraido = filaNome.extrairLote(3);
        System.out.println("Lote de 3 caracteres extraído. Tamanho do lote: " + loteExtraido.tamanho());
        System.out.println("Tamanho da fila original após extração: " + filaNome.tamanho());
    }
}
