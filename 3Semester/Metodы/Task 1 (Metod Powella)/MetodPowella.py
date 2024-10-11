import numpy as np
import math
import matplotlib.pyplot as plt

def f(x):
     return 0.5*x*x-math.sin(x) 
def search_min(a, b, E):


    points = []

    # Шаг 1
    dx = (b-a) / 3
    x1 = a
    x2 = x1 + dx

    # Шаг 2
    f1 = f(x1)
    f2 = f(x2)

    # Шаг 3
    if f1 > f2:
        x3 = x1 + 2 * dx
    else:
        x3 = x1 - dx

    print(f"{'x1':<10}{'x2':<10}{'x3':<10}{'x_bar':<10}{'f(x1)':<13}{'f(x2)':<12}{'f(x3)':<10}{'f(x_bar)':<10}")

    while True:
        # Шаг 4
        f1 = f(x1)
        f2 = f(x2)
        f3 = f(x3)
        f_min = min(f1, f2, f3)

        if f_min == f1:
            x_min = x1
        elif f_min == f2:
            x_min = x2
        else:
            x_min = x3

        # Шаг 5
        a1 = (f2 - f1) / (x2 - x1)
        a2 = 1 / (x3 - x2) * (((f3 - f1) / (x3 - x1)) - a1)
        x_bar = (x2 + x1) / 2 - a1 / (2 * a2)

        points.append((x1, f1))
        points.append((x2, f2))
        points.append((x3, f3))
        points.append((x_bar, f(x_bar)))

        print(
            f"{np.round(x1, 7):<10}{np.round(x2, 7):<10}{np.round(x3, 7):<10}{np.round(x_bar, 7):<10}{np.round(f(x1), 7):<12}{np.round(f(x2), 7):<13}{np.round(f(x3), 6):<10}{np.round(f(x_bar), 6):<10}")

        # Шаг 6
        if abs(f_min - f(x_bar)) <= E and abs(x_min - x_bar) <= E:
            return x_bar, points

        lst = {'x1': x1, 'x2': x2, 'x3': x3, 'x_bar': x_bar}

        # Конвертация словаря в список кортежей и сортировка по значениям
        sorted_lst = sorted(lst.items(), key=lambda x: x[1])

        # Проверка условия
        if f(x_min) > f(x_bar):
            index_x_bar = next(i for i, (name, _) in enumerate(sorted_lst) if name == 'x_bar')

            # Присвоение новых значений
            x1 = sorted_lst[index_x_bar - 1][1]  # Значение перед x_bar
            x2 = sorted_lst[index_x_bar][1]  # Значение x_bar
            x3 = sorted_lst[index_x_bar + 1][1]  # Значение после x_bar
        elif x_min==x2:
            index_x2 = next(i for i, (name, _) in enumerate(sorted_lst) if name == 'x2')

            # Присвоение новых значений
            x1 = sorted_lst[index_x2 - 1][1]  # Значение перед x2
            x2 = sorted_lst[index_x2][1]  # Значение x2
            x3 = sorted_lst[index_x2 + 1][1]  # Значение после
        else:
            index_x3 = next(i for i, (name, _) in enumerate(sorted_lst) if name == 'x3')

            # Присвоение новых значений
            x1 = sorted_lst[index_x3 - 1][1]  # Значение перед x2
            x2 = sorted_lst[index_x3][1]  # Значение x2
            x3 = x2+x2-x1 # Значение после

    return None

ans, points = search_min(-1, 4, 0.01)
print(f"\nОтвет: {ans}, f(x) = {f(ans)}")

x_vals = np.linspace(-1, 4, 100)
y_vals = [f(x) for x in x_vals]

x_points, y_points = zip(*points)

plt.figure(figsize=(10, 6))
plt.plot(x_vals, y_vals, label='f(x)', color='blue')
plt.scatter(x_points, y_points, color='red', label='Итерации', zorder=5)
plt.title('Метод Пауэлла')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.axhline(0, color='black', linewidth=0.5, linestyle='--')
plt.axvline(0, color='black', linewidth=0.5, linestyle='--')
plt.grid(True)
plt.legend()
plt.show()
