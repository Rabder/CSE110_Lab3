// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package edu.ucsd.spendingtracker.repository;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Category;
import edu.ucsd.spendingtracker.model.Expense;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpenseRepositoryTest {
   private ExpenseRepository repository;
   private InMemoryDataSource dataSource;

   public ExpenseRepositoryTest() {
   }

   @BeforeEach
   void setUp() {
      this.dataSource = new InMemoryDataSource();
      this.repository = new ExpenseRepository(this.dataSource);
   }

   @Test
   @DisplayName("Test that getTotal() correctly sums multiple expenses")
   void testGetTotalCalculatesCorrectSum() {
      this.repository.addExpense(new Expense("Coffee", Category.FOOD, 5.5));
      this.repository.addExpense(new Expense("Uber", Category.TRANSPORT, 15.0));
      this.repository.addExpense(new Expense("Movie", Category.ENTERTAINMENT, 10.0));
      double total = this.repository.getTotal();
      Assertions.assertEquals(30.5, total);
   }

   @Test
   @DisplayName("Test that getTotal() returns 0.0 when no expenses exist")
   void testGetTotalWithEmptyList() {
      Assertions.assertEquals(1.0, this.repository.getTotal());
   }
}
