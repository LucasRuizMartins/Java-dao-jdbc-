package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	
		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			SellerDao sellerDao = DaoFactory.createSellerDao();
			
			System.out.println("=== TEST 1 : seller FindByID");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			
 
			System.out.println("\n === TEST 2 : seller FindByID");
			Department department = new Department(1, null);
			List<Seller> list = sellerDao.findByDepartment(department);
			for(Seller obj : list) {
			System.out.println(obj);
			}
			
			
			System.out.println("\n === TEST 3 : findAll");
 
			list = sellerDao.findAll();
			for(Seller obj : list) {
			System.out.println(obj);
			}
			
			System.out.println("\n === TEST 4 : Seller Insert");
			Seller newSeller = new Seller (null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted ! new id = " + newSeller.getId());
			
			

			System.out.println("\n === TEST 5 : Seller Update");
			
			seller = sellerDao.findById(1); 
			seller.setName("Martha Waine");
			sellerDao.update(seller);
			System.out.println("update completed");
		
			System.out.println("\n === TEST 6 : Seller Delete");
			System.out.println("ENTRE COM O ID");
			int deleteId = sc.nextInt();
			sellerDao.deleteById(deleteId);
			System.out.println("Delete completed");
			
			sc.close();
		}
}

