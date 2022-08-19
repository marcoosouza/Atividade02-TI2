package app;

import java.util.*;
import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
	public static Scanner sc = new Scanner(System.in);
	public static UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public static void insertUser() {		
		int id = usuarioDAO.getNextId();
		System.out.println("Login: ");
		String login = sc.next();
		System.out.println("Senha: ");
		String password = sc.next();
		System.out.println("Sexo(M ou F): ");
		char sex = sc.next().charAt(0);
		
		Usuario usuario = new Usuario(id, login, password, sex); 
		
		if(usuarioDAO.insert(usuario)) {
			System.out.println("==== USUARIO CADASTRADO ====");
			
		}else {
			System.out.println("==== FALHA NO CADASTRO ====");
		}
	}
	
	public static void listUser() {
		List<Usuario> user = new ArrayList<Usuario>();
		user = usuarioDAO.get();
		for(Usuario u: user) {
			System.out.println(u.toString());
		}
	}
	
	public static void deleteUser(){
		System.out.println("Digite o nome do usuario que deseja excluir: ");
		String nome = sc.next();
		int id = usuarioDAO.getIdByName(nome);
		
		if(usuarioDAO.delete(id)) {
			System.out.println("==== USUARIO EXCLUIDO ====");
			
		}else {
			System.out.println("==== FALHA AO EXCLUIR USUARIO ====");
		}
	}
	
	public static void updateUser() {
		System.out.println("Digite o nome do usuario que deseja atualizar: ");
		String nome = sc.next();
		int id = usuarioDAO.getIdByName(nome);
		
		System.out.println("Digite as novas informacoes: ");
		System.out.println("Login: ");
		String login = sc.next();
		System.out.println("Senha: ");
		String password = sc.next();
		System.out.println("Sexo(M ou F): ");
		char sex = sc.next().charAt(0);
		
		Usuario userUpd = new Usuario(id, login, password, sex);
		if(usuarioDAO.update(userUpd)) {
			System.out.println("==== USUARIO ATUALIZADO ====");
			
		}else {
			System.out.println("==== FALHA AO ATUALIZAR USUARIO ====");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("\n\n==== CADASTRO DE USUARIO ==== ");
		int option;
		
		do {
		System.out.println("\n\nSelecione uma opcao:\n1- Listar\n2- Inserir\n3- Excluir \n4- Atualizar\n5- Sair");
		
		option = sc.nextInt();
		
		switch(option) {
		case 1: 
			listUser();
		break;
		case 2: 
			insertUser();
		break;	
		case 3:
			deleteUser();
		break;
		case 4: 
			updateUser();
		break;
		case 5:
		break;
		default:
			System.out.println("\n\n==== ERRO: OPCAO INVALIDA ====");
		}
		
		}while(option != 5);
		
		System.out.println("\n\n==== FIM DA SESSAO ====");
		
		/*
		
		System.out.println("\n\n==== Inserir usuário === ");
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(usuarioDAO.insert(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "pablo"));
			
		System.out.println("\n\n==== Mostrar usuários do sexo masculino === ");
		List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Atualizar senha (código (" + usuario.getCodigo() + ") === ");
		usuario.setSenha(DAO.toMD5("pablo"));
		usuarioDAO.update(usuario);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", DAO.toMD5("pablo")));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
		usuarios = usuarioDAO.getOrderByCodigo();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir usuário (código " + usuario.getCodigo() + ") === ");
		usuarioDAO.delete(usuario.getCodigo());
		
		System.out.println("\n\n==== Mostrar usuários ordenados por login === ");
		usuarios = usuarioDAO.getOrderByLogin();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}
		*/
	}
}