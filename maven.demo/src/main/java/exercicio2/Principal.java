package exercicio2;

import java.util.Scanner;

public class Principal {
	
	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		Usuario[] usuarios = dao.getUsuarios();
		Usuario usuario = new Usuario();
		
		int opcao = 0;
		
		do {
			System.out.println("Selecione a Opção que deseja: ");
			System.out.println("1) '1' para inserir um novo usuário\n"+
							   "2) '2' para atualizar um usuário existente\n"+ 
							   "3) '3' para remover um usuário existente\n"+
							   "4) '4' para mostrar os usuários da tabela\n"+
							   "5) '5' para sair do menu de opções e finalizar o programa");
			
			opcao = sc.nextInt();
			
			
			switch (opcao) {
			//Inserir um elemento na tabela
			case 1:
				System.out.println("\nInsira o código do novo usuário: ");
				usuario.setCodigo(sc.nextInt());
				System.out.println("Insira o login do novo usuário: ");
				usuario.setLogin(sc.next());
				System.out.println("Insira a senha do novo usuário: ");
				usuario.setSenha(sc.next());
				System.out.println("Insira o sexo do novo usuário: ");
				usuario.setSexo(sc.next());
				
				if(dao.inserirUsuario(usuario) == true) {
					System.out.println("\nInserção realizada com sucesso -> " + usuario.toString());
				}
				break;
				
			//Atualizar usuário
			case 2:
				System.out.println("\nInsira o código do usuário que deseja atualizar: ");
				usuario.setCodigo(sc.nextInt());
				System.out.println("Insira o novo login do usuário: ");
				usuario.setLogin(sc.next());
				System.out.println("Insira a nova senha do usuário: ");
				usuario.setSenha(sc.next());
				System.out.println("Insira o novo sexo do usuário: ");
				usuario.setSexo(sc.next());
				
				if(dao.atualizarUsuario(usuario) == true) {
					System.out.println("\nAtualização realizada com sucesso -> " + usuario.toString());
				}
				
				break;
			
			
			//Excluir usuário
			case 3:
				System.out.println("\nInsira o código do usuário que deseja excluir da tabela: ");
				usuario.setCodigo(sc.nextInt());
				if(dao.excluirUsuario(usuario.getCodigo()) == true) {
					System.out.println("\nRemoção realizada com sucesso.");
				}
				break;
			
			//Mostrar usuários
			case 4:
				usuarios = dao.getUsuarios();
				System.out.println("\n==== Usuários ==== ");		
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
				break;
			}
			
			System.out.println("\n\n");
		
		} while (opcao != 5);
		
		System.out.println("Finalizando o programa ...");

		
		dao.close();
		
	}
	
}
