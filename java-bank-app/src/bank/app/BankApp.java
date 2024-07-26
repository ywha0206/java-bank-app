package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = 0;
			
			try {
				selectNo = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				continue;
			}
			
			if(selectNo == 1) {
				createAccount();
			}else if(selectNo == 2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if(selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}
	
	private static void createAccount() {
		System.out.println("-------------------계좌생성-------------------");
		System.out.print("계좌번호: ");
		String ano1 = scanner.nextLine();
		System.out.print("계좌주: ");
		String owner1 = scanner.nextLine();
		System.out.println("초기입금액: ");
		int balance1 = scanner.nextInt();
		scanner.nextLine();
		
		Account addAccount = new Account(ano1, owner1, balance1);
		accounts.add(addAccount);
		
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		System.out.println("-------------------계좌목록-------------------");
			if(accounts.isEmpty()) {
				System.out.println("등록된 계좌가 없습니다.");
			}else {
				for(Account account : accounts) {
					System.out.println(account);
				}
			}
	}
	
	private static void deposit() {
	    System.out.println("-------------------예금-------------------");
	    System.out.print("계좌번호: ");
	    String ano2 = scanner.nextLine();
	    System.out.print("예금액: ");
	    int deposit = scanner.nextInt();
	    scanner.nextLine();  // 버퍼 비우기
	    Account account = findAccount(ano2);
	    if (account != null) {
	        account.deposit(deposit);
	        System.out.println("결과: 예금이 성공되었습니다.");
	    } else {
	        System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	    }
	}
	
	private static void withdraw() {
	    System.out.println("-------------------출금-------------------");
	    System.out.print("계좌번호: ");
	    String ano = scanner.nextLine();
	    System.out.print("출금액: ");
	    int amount = scanner.nextInt();
	    scanner.nextLine();  // 버퍼 비우기

	    Account account = findAccount(ano);
	    if (account != null) {
	        if (account.withdraw(amount)) {
	            System.out.println("결과: 출금이 성공되었습니다.");
	        } else {
	            System.out.println("결과: 잔액이 부족합니다.");
	        }
	    } else {
	        System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	    }
	}
	
	private static Account findAccount(String ano) {
		
		for(Account account: accounts) {
			if(account.getAno().equals(ano)) {
				return account;
			}
		}
		return null;
	}
	
}

