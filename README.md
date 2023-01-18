# dji-shop-tests

Java+Selenium automated tests for store.dji.com (learning purposes)
Intellij IDEA with Java 17 + Gradle onboard.

Test task: Go to DJI store "Camera Drones" section, then get all products, purchase each product and compare name and price. Repeat.

Test plan:
1. Open web page https://store.dji.com/lv/selection/camera-drones?from=store-nav
2. Get all product links in the list
3. Start FOR loop and take first product link in the list
4. Open product page and get name and price (expected)
5. Buy product and go to cart
6. Get product name and price in cart (actual)
7. Compare if actual name and price is equal expected name and price
8. Delete product from cart
9. Take next product link in the list. Repeat all steps until last link.

Expected:
All tests passed if actual name and price for each product is equal expected name and price in cart