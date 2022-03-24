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
			System.out.println("Selecione a Op��o que deseja: ");
			System.out.println("1) '1' para inserir um novo usu�rio\n"+
							   "2) '2' para atualizar um usu�rio existente\n"+ 
							   "3) '3' para remover um usu�rio existente\n"+
							   "4) '4' para mostrar os usu�rios da tabela\n"+
							   "5) '5' para sair do menu de op��es e finalizar o programa");
			
			opcao = sc.nextInt();
			
			
			switch (opcao) {
			//Inserir um elemento na tabela
			case 1:
				System.out.println("\nInsira o c�digo do novo usu�rio: ");
				usuario.setCodigo(sc.nextInt());
				System.out.println("Insira o login do novo usu�rio: ");
				usuario.setLogin(sc.next());
				System.out.println("Insira a senha do novo usu�rio: ");
				usuario.setSenha(sc.next());
				System.out.println("Insira o sexo do novo usu�rio: ");
				usuario.setSexo(sc.next());
				
				if(dao.inserirUsuario(usuario) == true) {
					System.out.println("\nInser��o realizada com sucesso -> " + usuario.toString());
				}
				break;
				
			//Atualizar usu�rio
			case 2:
				System.out.println("\nInsira o c�digo do usu�rio que deseja atualizar: ");
				usuario.setCodigo(sc.nextInt());
				System.out.println("Insira o novo login do usu�rio: ");
				usuario.setLogin(sc.next());
				System.out.println("Insira a nova senha do usu�rio: ");
				usuario.setSenha(sc.next());
				System.out.println("Insira o novo sexo do usu�rio: ");
				usuario.setSexo(sc.next());
				
				if(dao.atualizarUsuario(usuario) == true) {
					System.out.println("\nAtualiza��o realizada com sucesso -> " + usuario.toString());
				}
				
				break;
			
			
			//Excluir usu�rio
			case 3:
				System.out.println("\nInsira o c�digo do usu�rio que deseja excluir da tabela: ");
				usuario.setCodigo(sc.nextInt());
				if(dao.excluirUsuario(usuario.getCodigo()) == true) {
					System.out.println("\nRemo��o realizada com sucesso.");
				}
				break;
			
			//Mostrar usu�rios
			case 4:
				usuarios = dao.getUsuarios();
				System.out.println("\n==== Usu�rios ==== ");		
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
