# SI_2024_lab2_213001
# Матеј Иванковиќ, 213001
_____________________________________

### 2. Control Flow Graph 
![ControlFlowGraph_213001 drawio](https://github.com/MatejIvankovikj/SI_2024_lab2_213001/assets/107055729/15091aa6-bb4d-4c65-bbcc-f9e804e85046)

### 3. Цикломатска комплексност:
Цикломатската комплексност се добива со формулата P + 1, каде што P е бројот на предикатни јазли (if циклуси, for циклуси и сл.). Во овој случај P = 9, па цикломатската комплексност е 9+1 = 10.

### 4. За да се постигне Every Branch Case, мене ми беа потребни 5 случаи и тоа следните:
        Прв тест случај --> allItems = null: ја опфаќа гранката (1-2);
        Втор тест случај --> Item(null, null, 100, 0): опфатени се гранките (1-3), (3-4), (4-5), (5-7), (7-8), (8-9), (9-10);
        Трет тест случај --> Item(item2, 12a4, 100, 0): опфатени се гранките: (1-2), (1-3), (3-4), (4-5), (5-7), (7-8), (7-9), (9-11), (11-12), (12-14), (14-15), (15-17);
        Четврти тест случај --> Item(item3, 1234, 100, 0.2): опфатени се гранките: (1-2), (1-3), (3-4), (4-5), (4-6), (5-7), (6-23), (7-8), (7-9), (9-11), (11-12), (12-13), (12-14), (13-19), (14-15), (15-16), (16-11), (19-20), (20-21), (22-4);
        Пети тест случај --> Item(item4, 1234, 200, 0): опфатени се гранките: (1-2), (1-3), (3-4), (4-5), (4-6), (5-7), (6-24), (7-8), (7-9), (9-11), (11-12), (12-13), (12-14), (13-18), (14-15), (15-16), (16-11), (18-20), (20-22), (21-22), (22-4);

![ControlFlowGraph_1_213001](https://github.com/MatejIvankovikj/SI_2024_lab2_213001/assets/107055729/83161792-135f-4fc1-83ee-36edaa490390)

### 5. На мене ми беа потребни 8 тест случаи според Multiple Condition критериумот за да биде исполнет условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'). Тоа се следните: 

    void testMultipleCondition() {

        Item item1 = new Item("item1", "0123", 350, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item1), 30)); // suma = 35 - 30 = 5, payment = 30 --> True

        Item item2 = new Item("item2", "0123", 250, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item2), 30)); // suma = 25, payment = 30 --> True

        Item item3 = new Item("item3", "0123", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(item3), 30)); // suma = 350, payment = 30 --> False

        Item item4 = new Item("item4", "1123", 350, 0.1f);
        assertFalse(SILab2.checkCart(Collections.singletonList(item4), 30)); // suma = 35, payment = 30 --> False

        Item item5 = new Item("item5", "1123", 250, 0);
        assertTrue(SILab2.checkCart(Collections.singletonList(item5), 300)); // suma = 250, payment = 300 --> True

        Item item6 = new Item("item6", "1123", 250, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item6), 30)); // suma = 25, payment = 30 --> True

        Item item7 = new Item("item7", "1123", 350, 0.1f);
        assertFalse(SILab2.checkCart(Collections.singletonList(item7), 30)); // suma = 35, payment = 30 --> False

        Item item8 = new Item("item8", "0123", 300, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item8), 30)); // suma = 30, payment = 30 --> True
    }


