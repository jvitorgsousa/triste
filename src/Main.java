import java.util.Scanner;
import generos.*;
import recomendacoes.*;
import usuario.*;
import jogos.*;

public class Main {
    private static GerenciadorDeUsuarios gerenciadorDeUsuarios = new GerenciadorDeUsuarios(); 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = null;

        gerenciadorDeUsuarios.adicionarUsuario(new Usuario("usuario1", new AutenticacaoSimples("usuario1", "senha1")));
        gerenciadorDeUsuarios.adicionarUsuario(new Usuario("usuario2", new AutenticacaoSimples("usuario2", "senha2")));

        while(true) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Entrar na conta");
            System.out.println("2. Cadastrar conta");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            if (opcao == 1) {
                usuario = realizarLogin(scanner);
                if (usuario != null) {
                    SistemaDeRecomendacaoFacade sistemaDeRecomendacao = new SistemaDeRecomendacaoFacade(usuario, new Acao());
                    exibirMenuPrincipal(scanner, usuario, sistemaDeRecomendacao);
                    break; 
                }
            } else if (opcao == 2) {
                System.out.print("Digite um nome de usuário para cadastro: ");
                String novoUsuarioNome = scanner.nextLine();
                System.out.print("Digite uma senha para cadastro: ");
                String novaSenha = scanner.nextLine();

                usuario = new Usuario(novoUsuarioNome, new AutenticacaoSimples(novoUsuarioNome, novaSenha));
                gerenciadorDeUsuarios.adicionarUsuario(usuario); 
                System.out.println("Usuário cadastrado com sucesso!");
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break; 
            }

            System.out.print("\033[H\033[2J");
        }

        scanner.close();
    }

    private static Usuario realizarLogin(Scanner scanner) {
        System.out.print("Digite seu usuário: ");
        String usuarioInput = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senhaInput = scanner.nextLine();

        Usuario usuarioEncontrado = gerenciadorDeUsuarios.buscarUsuarioPorNome(usuarioInput);

        if (usuarioEncontrado != null && usuarioEncontrado.autenticar(usuarioInput, senhaInput)) {
            System.out.println("Autenticação bem-sucedida!");
            return usuarioEncontrado;
        } else {
            System.out.println("Login inválido. Por favor, tente novamente.");
            return null;
        }
    }

    private static void exibirMenuPrincipal(Scanner scanner, Usuario usuario, SistemaDeRecomendacaoFacade sistemaDeRecomendacao) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Ver avaliações de jogos");
            System.out.println("2. Avaliar um novo jogo");
            System.out.println("3. Ver recomendações de jogos");
            System.out.println("4. Sair");
            int acao = scanner.nextInt();
            scanner.nextLine();  

            switch (acao) {
                case 1:
                    System.out.println("\n\nAvaliações dos jogos:");
                    for (Jogo jogo : usuario.getHistorico().getJogosJogados()) {
                        System.out.println(jogo);
                    }
                    break;
                case 2:
                    System.out.println("\n\nEscolha o gênero do jogo:");
                    System.out.println("1. Ação");
                    System.out.println("2. Aventura");
                    System.out.println("3. Esportes");
                    System.out.println("4. RPG");
                    int generoEscolhido = scanner.nextInt();
                    scanner.nextLine();  

                    Genero generoJogo = null;
                    switch (generoEscolhido) {
                        case 1:
                            generoJogo = new Acao();
                            break;
                        case 2:
                            generoJogo = new Aventura();
                            break;
                        case 3:
                            generoJogo = new Esportes();
                            break;
                        case 4:
                            generoJogo = new RPG(); 
                            break;
                        default:
                            System.out.println("Gênero inválido.");
                            break;
                    }

                    if (generoJogo != null) {
                        System.out.print("Digite o nome do jogo: ");
                        String nomeJogo = scanner.nextLine();
                        
                        double avaliacao = -1;
                        while (avaliacao < 0 || avaliacao > 5) {
                            System.out.print("Digite a avaliação (0 a 5): ");
                            avaliacao = scanner.nextDouble();
                            scanner.nextLine();  

                            if (avaliacao < 0 || avaliacao > 5) {
                                System.out.println("Erro: A avaliação deve estar entre 0 e 5. Tente novamente.");
                            }
                        }

                        Jogo novoJogo = new Jogo(nomeJogo, generoJogo);
                        novoJogo.avaliar(avaliacao);
                        usuario.getHistorico().adicionarJogo(novoJogo);

                        System.out.println("Jogo avaliado e adicionado ao histórico.");
                    } else {
                        System.out.println("Erro ao escolher gênero. Jogo não adicionado.");
                    }
                    break;
                case 3:
                    System.out.println("\n\nEscolha uma estratégia de recomendação:");
                    System.out.println("1. Recomendação por avaliação (jogos bem avaliados)");
                    System.out.println("2. Recomendação por gênero preferido");

                    int estrategia = scanner.nextInt();
                    scanner.nextLine(); 
                    if (estrategia == 1) {
                        sistemaDeRecomendacao.setEstrategiaRecomendacao(new RecomendacaoPorAvaliacao());
                    } else if (estrategia == 2) {
                        System.out.println("\n\nEscolha o seu gênero preferido:");
                        System.out.println("1. Ação");
                        System.out.println("2. Aventura");
                        System.out.println("3. Esportes");
                        System.out.println("4. RPG");

                        int generoEscolhidoRecomendacao = scanner.nextInt();
                        scanner.nextLine();  
                        Genero generoPreferido = null;
                        switch (generoEscolhidoRecomendacao) {
                            case 1:
                                generoPreferido = new Acao();
                                System.out.println(generoPreferido.descricao());
                                break;
                            case 2:
                                generoPreferido = new Aventura();
                                System.out.println(generoPreferido.descricao());
                                break;
                            case 3:
                                generoPreferido = new Esportes();
                                System.out.println(generoPreferido.descricao());
                                break;
                            case 4:
                                generoPreferido = new RPG();
                                System.out.println(generoPreferido.descricao());
                                break;
                            default:
                                System.out.println("Gênero inválido.");
                                break;
                        }

                        if (generoPreferido != null) {
                            sistemaDeRecomendacao.setEstrategiaRecomendacao(new RecomendacaoPorGenero(generoPreferido));
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    sistemaDeRecomendacao.recomendarJogos();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
