# 基于Java开发的房屋管理系统
使用了IntelliJ IDEA 2024.01 版本进行全栈开发  
使用了**Microsoft Build of OpenJDK 21**版本为开发基本。  
采用了 JUnit5.8.1作为测试用例框架。  
### 开源声明  
本项目采用了Apache-2.0开源协议进行代码分发。  
其他项目均采用各自的开源协议。  

-----
入口文件是位于**src/com/bw/impl**下的[**House.java**](https://github.com/kserksi/java-house/blob/master/src/com/bw/impl/House.java)。  
他是整体程序入口点。    
测试入口点是位于**src/com/bw/impl**下的[[**LeaseSystemTests**](https://github.com/kserksi/java-house/blob/master/src/com/bw/impl/LeaseSystemTests.java)。   
  
-----
### 如何修改/添加房屋测试数据    
目前程序中方便测试包括了一个写好的房屋数据，位于**LeaseSystemTests.java**中的**testUpdateLeaseStatus**方法。  
~~~java
@Test
public void testUpdateLeaseStatus() {
    String address = "123 Main St.";
    House house = new House(address, 100.0, false); // Create a new house instance
    leaseManager.addHouse(house); // Assuming there's an addHouse method in LeaseManager

    boolean isRented = true;
    leaseManager.updateLeaseStatus(address, isRented);

    House updatedHouse = leaseManager.getHouse(address);
    assertNotNull(updatedHouse, "House should exist after being added or updated.");
    assertTrue(updatedHouse.isRented(), "House should be rented after update.");
}
~~~
在这个代码中，首先创建了一个新的House实例，然后使用addHouse方法将其添加到LeaseManager中。之后，我们调用updateLeaseStatus来更新房屋的状态，并再次从LeaseManager中获取房屋以验证状态是否已更新。    
**如何添加一个测试房屋数据**    
要向LeaseManager添加一个房屋，需要确保LeaseManager类中包含一个用于添加房屋的方法。  
在本项目中，我们可以创建一个新的House对象，然后调用addHouse方法将其添加到LeaseManager中。
~~~java
@Test
public void testAddHouse() {
    String address = "123 Main St.";
    double area = 100.0;
    boolean isRented = false;
    House newHouse = new House(address, area, isRented);

    leaseManager.addHouse(newHouse);

    // 确认房屋已被添加
    assertTrue(leaseManager.getHouses().contains(newHouse), "The house should be added to the manager.");
}
~~~
在这个示例中，我们首先创建了一个新的House对象，然后调用了addHouse方法将其添加到LeaseManager中。之后，我们使用assertTrue断言来确认新添加的房屋存在于LeaseManager的房屋列表中。    

---
没有什么其他问题了，记得玩的开心。🎊
