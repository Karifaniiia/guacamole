package com.example.zadanie3;

public class MainApp {
    public static void main(String[] args) {
        String[][] array = {
                {"8", "6", "8", "2"},
                {"7", "л", "4", "1"},
                {"9", "6", "t", "4"},
                {"9", "6", "248","h"},
//                {"9", "6", "248", "4"},
//               {"7", "6", "4","1"},
        };

        try {
            if (check(array))
                System.out.println("Сумма чисел массива: " + sum);

        } catch (MySizeArrayException | MyArrayDataException  e) {
            e.printStackTrace();
        }
    }

    protected static int sum = 0;
    static int n = 0;

    public static boolean check(String[][] array)
            throws MySizeArrayException,
            MyArrayDataException
             {
        boolean tmp = true;
        if (array.length != 4) {
            throw new MySizeArrayException("Ваш массив не соответствует размеру 4x4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MySizeArrayException("Ваш массив не соответствует размеру 4x4");
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    if (array[i][j].matches("(?ui:[0-9]+[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ]+)|" +
                            "(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ]+[0-9]+)|" +
                            "(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")) {
                        throw new MyConsonantsException(i, j, array[i][j]);
                    }
                    int n = Integer.valueOf(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                } catch (MyConsonantsException ee) {
                    ee.printStackTrace();
                    tmp = true;
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            try {
                sum += Integer.valueOf(array[i][j]);
            }
            catch (NumberFormatException e) {
                try {
                    if ((array[i][j].matches("(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")))
                        throw new MyConsonantsException(i, j, array[i][j]);
                }
                catch (MyConsonantsException ee) {
                  //  ee.printStackTrace();
                    tmp = true;
                }

            }
        }
    }
        return  tmp;
}
}





//                try {
//                    if (!array[i][j].matches("(?ui:[0-9qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ]+)")) {
//                        throw new MyArrayDataException(i, j, array[i][j]);
//                    }
//
//                    if (array[i][j].matches("(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")) {
//                        throw new MyConsonantsException(i, j, array[i][j]);
//                    }
//
//                    sum += Integer.parseInt(array[i][j]);
//
//                } catch (MyConsonantsException e) {
//                    throw new MyConsonantsException(i, j, array[i][j]);
////                    System.err.println(e.getMessage());
//                } catch (NumberFormatException e) {
//                    throw new MyArrayDataException(i, j, array[i][j]);
//                }
//            }
//        }
//        return tmp;
//    }
//}

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                try {
//                    if ((!array[i][j].matches("(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")))
//                        n = Integer.valueOf(array[i][j]);
//                    //if (array[i][j].length() > 6) throw new MyArrayDataException(i, j, array[i][j]);
//                } catch (NumberFormatException e) {
//                    throw new MyArrayDataException(i, j, array[i][j]);
//                }
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                try {
//                    sum += Integer.valueOf(array[i][j]);
//                    if (array[i][j].matches("(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ]+)")) {
//                        throw new MyConsonantsException(i,j,array[i][j]);
//                    }
//                } catch (MyConsonantsException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//        return tmp;
//    }
//}







//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                String element = array[i][j];
//
//                if (array[i][j].length() > 2) {
//                    throw new MyArrayDataException(i, j, element);
//                }
//                System.out.println(1);
//                if (!element.matches("(?ui:[1234567890qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")){
//                    System.out.println(111);
//                    throw new MyArrayDataException(i, j, element);
//                } else {
//                    int number = Integer.parseInt(element);
//                    sum += number;
//                }
//
//                    if (element.matches("(?ui:[qwrtpsdfghjklzxcvbnmбвгджзйклмнпрстфхцчшщ])")) {
//                        System.out.println(sum);
//                    throw new MyConsonantsException(i, j, element);
//                    }
//
//                try {
//                    int number = Integer.valueOf(element);
//                    sum += number;
//                } catch (NumberFormatException e) {
//                    throw new MyArrayDataException(i, j, element);
//                }
//            }
//        }
//        return true;
//    }
//}
