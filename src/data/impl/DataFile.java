package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import model.Bill;
import model.Customer;
import model.Menu;

public class DataFile implements DAO {

	@Override
	public ArrayList<Menu> readDataFromFile(String fileName) {
		ArrayList<Menu> menus = new ArrayList<>();
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				int id = scan.nextInt();
				String category = scan.next();
				String name = scan.next();
				int price = scan.nextInt();
				Menu s = new Menu(id, category, name, price);
				menus.add(s);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return menus;
	}

	@Override
	public void writeFile(HashMap<Menu, Integer> hashFile, String path) {
		try {
			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Menu m : hashFile.keySet()) {
				bw.newLine();
				bw.append(m.getName());
				bw.append(" ");
				bw.append(String.valueOf(hashFile.get(m)));
			}
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public HashMap<String, Integer> readDataToAdmin(String fileName) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		File file = new File(fileName);
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String name = scan.next();
				int count = scan.nextInt();
				if (!hashMap.containsKey(name)) {
					hashMap.put(name, count);
				} else {
					int newValue = 0;
					newValue = count + hashMap.get(name);
					hashMap.replace(name, newValue);
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return hashMap;
	}

	@Override
	public void deleteData(String path) {
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.print("");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Bill> readBill(String fileName) {
		ArrayList<Bill> bills = new ArrayList<>();
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String phone = scan.next();
				String bankId = scan.next();
				int payTotal = scan.nextInt();
				Bill s = new Bill(phone, bankId, payTotal);
				bills.add(s);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return bills;
	}

	@Override
	public void writeBillFile(Bill c, String path) {
		try {
			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.append(c.getphoneNumber());
			bw.append(" ");
			bw.append(c.getBankId());
			bw.append(" ");
			bw.append(String.valueOf(c.getPayTotal()));
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void writeCus(Customer cus, String path, HashMap<Menu, Integer> hashCus) {
		try {
			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.append(cus.getPhoneNumber());
			bw.append(" ");
			bw.append(String.valueOf(cus.getPayTotal()));
			bw.append(" ");
			for (Menu m : hashCus.keySet()) {
				bw.append(m.getName());
				bw.append(" ");
				bw.append(String.valueOf(hashCus.get(m)));
				bw.append(" ");
			}
			bw.append("end");
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public HashMap<Customer, Integer> readCustomerInfo(String fileName) {
		HashMap<Customer, Integer> hashMap = new HashMap<Customer, Integer>();
		File file = new File(fileName);
		try {
			Customer cus = null;
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String phone = scan.next();
				int total = scan.nextInt();
				cus = new Customer(phone, total);
				if (!hashMap.containsKey(cus)) {
					hashMap.put(cus, total);
				} else {
					int newValue = 0;
					newValue = total + hashMap.get(cus);
					hashMap.replace(cus, newValue);
				}
				scan.nextLine();
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return hashMap;
	}

	@Override
	public LinkedHashMap<String, Customer> readCustomerMenu(String fileName, String phoneSearch) {
		LinkedHashMap<String, Customer> hashMap = new LinkedHashMap<String, Customer>();
		LinkedHashMap<Menu, Integer> hashTemp = null;

		File file = new File(fileName);
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			hashTemp = new LinkedHashMap<Menu, Integer>();
			Customer c = null;
			while (scan.hasNext()) {
				String phone = scan.next();
				int total = scan.nextInt();
				c = new Customer(phone, total);
				if (hashMap.containsKey(c.getPhoneNumber())) {
					while (true) {
						String name = scan.next();
						if (name.equalsIgnoreCase("end"))
							break;
						if (!phoneSearch.equalsIgnoreCase(phone)) {
							continue;
						}

						int count = scan.nextInt();
						Menu m = findMenu(name);
						if (!hashTemp.containsKey(m)) {
							hashTemp.put(m, count);
						} else {
							int newValue = hashTemp.get(m) + count;
							hashTemp.replace(m, newValue);
						}
						c.hashCus.putAll(hashTemp);
					}
					hashMap.put(c.getPhoneNumber(), c);
				} else {
					while (true) {
						String name = scan.next();
						if (name.equalsIgnoreCase("end"))
							break;
						if (!phoneSearch.equalsIgnoreCase(phone)) {
							continue;
						}

						int count = scan.nextInt();
						Menu m = findMenu(name);
						hashTemp.put(m, count);
						hashMap.put(phone, c);
						c.hashCus.putAll(hashTemp);
					}
					hashMap.put(c.getPhoneNumber(), c);
				}
			}
			return hashMap;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	Menu findMenu(String name) {
		for (Menu m : readDataFromFile("data.txt")) {
			if (m.getName().equalsIgnoreCase(name))
				return m;
		}
		return null;
	}

}
