# ganfan
**简单介绍**
   这个项目实现了一个基本的餐饮管理系统。员工可以登录系统后,进行餐桌管理、菜单管理和账单管理等操作。
   具体包含以下主要功能:
   1. 员工管理:支持员工登录和验证,员工需要输入员工号和密码登录系统。
   2. 餐桌管理:可以查看餐桌状态,进行餐桌预定。需要选择餐桌号和输入预定信息实现预定。
   3. 菜单管理:可以查看所有的菜单信息。
   4. 下单管理:选择餐桌和菜单可以进行下单,生成对应的账单。
   5. 账单管理:可以查看未结账的账单信息,选择餐桌和支付方式完成账单结算。
   系统通过菜单与用户交互,调用相应的服务实现登录验证、餐桌预定、下单等功能。

   **主要类说明**
   1. MHLView:系统界面视图,提供菜单交互。
   2. Employee:员工实体类。 
   3. EmployeeService:员工管理服务,员工登录验证。
   4. DingTable:餐桌实体类。
   5. DingTableService:餐桌管理服务,餐桌列表和预定。
   6. Menu:菜单实体类。 
   7. MenuService:菜单管理服务,提供所有菜单列表。
   8. Bill:账单实体类。
   9. BillService:账单管理服务,生成账单和结账。

   **具体分析**
   1. MHLView:系统的主界面,提供主菜单和二级菜单交互,调用相应服务实现系统功能。
   2. Employee:员工实体类,包含员工号、密码、姓名等信息。
   3. EmployeeService:员工管理服务,提供员工登录验证,调用EmployeeDao操作员工数据库。
   4. EmployeeDao:员工数据访问对象,操作员工数据库表,提供增删改查等功能。
   5. DingTable:餐桌实体类,包含餐桌号、状态、预定人信息等。
   6. DingTableService:餐桌管理服务,提供餐桌列表和预定服务,调用DingTableDao操作餐桌数据库。
   7. DingTableDao:餐桌数据访问对象,操作餐桌数据库表,提供增删改查等功能。
   8. Menu:菜单实体类,包含菜单号、菜名、类型、价格等信息。
   9. MenuService:菜单管理服务,提供所有菜单列表,调用MenuDao操作菜单数据库。
   10. MenuDao:菜单数据访问对象,操作菜单数据库表,提供增删改查等功能。
   11. Bill:账单实体类,包含账单号、菜品号、数量、金额、餐桌号、日期等信息。
   12. BillService:账单管理服务,提供生成账单、订单服务以及结账服务,调用BillDao操作账单数据库。
   13. BillDao:账单数据访问对象,操作账单数据库表,提供增删改查等功能。