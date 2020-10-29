package data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import model.Bill;
import model.Customer;
import model.Menu;

public interface DAO {
	ArrayList<Menu> readDataFromFile(String fileName);  //메뉴 리스트를 읽어
	ArrayList<Bill> readBill(String fileName); //계선한 손님의 정보를 출력
	void writeBillFile(Bill cus, String path);  //주문한 손님의 정보 쓰기 -- 영수증
	HashMap<String, Integer>readDataToAdmin(String fileName); //주문된 메뉴의 총매출 수량 file으로부터 읽어
	void writeFile(HashMap<Menu, Integer> hashFile, String path);  //주문된 메뉴 몇 수량 쓰기 
	void deleteData(String path); //오늘 장사 끈난 후 낼 오픈 한 후 어제 손님정보 몇 총 매출 수량 다 치움
	void writeCus (Customer cus, String path, HashMap<Menu, Integer> hashCus); //손님의 정보 쓰기
	HashMap<Customer, Integer> readCustomerInfo(String fileName); //손님의 정보를 읽이
	LinkedHashMap<String, Customer> readCustomerMenu(String fileName, String phoneSearch); //손님의 주문한 각 물건 출력
}
