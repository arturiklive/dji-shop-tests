# dji-shop-tests
Java+Selenium automated tests for store.dji.com (learning purposes)
Intellij IDEA with Java 17 + Gradle onboard.

Test aim:
Purchasing functions with selected product name and price check in shopping cart. Clear cart + test next product.

Test plan:
1. Open web page https://store.dji.com/ 
2. Open drones listing page https://store.dji.com/lv/selection/camera-drones
3. Select all product links in list
4. Start cycle with all items in list
5. Select and save product name and price
6. Buy product
7. Check "item added to cart successfully" message (Assert)
8. Go to shopping cart
9. Select item name and price and cart. Compare to products listing page purchased item name and price (Assert)
10. Clear shopping cart
11. Repeat with next product link
