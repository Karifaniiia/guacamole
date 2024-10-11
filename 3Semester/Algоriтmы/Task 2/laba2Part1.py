import math
import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate

# полный набор данных
def bigData():
    n = 10
    i = np.arange(0, 2 * n + 1)
    VY = [1.0, 1.34, 1.75, 2.18, 2.53, 2.71, 2.65, 2.37, 1.97, 1.54, 1.16, 0.86, 0.64, 0.5, 0.42, 0.37, 0.36, 0.39, 0.45, 0.56, 0.74]
    VX = 2 * math.pi * i / (2 * n + 1)
    XJ = []
    scale = 100
    J = 0
    while J < scale:
        XJ.append(min(VX) + J * (max(VX)-min(VX)) / scale)
        J = J + 1
    return VY, VX, XJ

# алгоритм тригонометрический интерполяции
def trigonometricInterpolation(x):
    VY, VX, XJ = bigData()
    n = 10
    i = 0
    a0 = 0
    while i < 2 * n + 1:
        a0 += VY[i]
        i = i + 1
    a0 = a0 / (2 * n + 1)
    k = 1
    ak = []
    bk = []
    while k < n + 1:
        a = b = 0
        i = 0
        while i < 2 * n + 1:
            a += VY[i] * math.cos(k * VX[i])
            b += VY[i] * math.sin(k * VX[i])
            i = i + 1
        ak.append(a / (2 * n + 1))
        bk.append(b / (2 * n + 1))
        k = k + 1
    i = 0
    c = []
    c1 = []
    while i < len(x):
        p = 0
        p1 = 0
        k = 1
        k1 = 0
        while k < n + 1:
            p += ak[k1] * math.cos(k * x[i])
            p1 += bk[k1] * math.sin(k * x[i])
            k = k + 1
            k1 = k1 + 1
        c.append(p)
        c1.append(p1)
        i = i + 1
    k = 0
    P = []
    while k < len(c):
        P.append((c[k] + c1[k]) * 2 + a0)
        k = k + 1
    return P

# кусочно-линейная интерполяция
def piecewiseLinearInterpolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="linear")
    return f(x)

# сплайн-линейная интерполяция
def splineLinearInterpolation(x):
    VY, VX, XJ = bigData()
    C = interpolate.splrep(VX, VY)
    f = interpolate.splev(x, C)
    return f

# сплайн-кубическая интерполяция
def splineCubicInterpolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, "cubic")
    return f(x)

# сплайн-параболическая интерполяция
def splineParabolicInterpolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="quadratic", fill_value="extrapolate")
    return f(x)

# кусочно-линейная экстраполяция
def piecewiseLinearExtrapolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="linear", fill_value="extrapolate")
    return f(x)

# сплайн-кубическая экстраполяция
def splineCubicExtrapolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, "cubic", fill_value="extrapolate")
    return f(x)

# сплайн-параболическая экстраполяция
def splineParabolicExtrapolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="quadratic", fill_value="extrapolate")
    return f(x)

# график кусочно-линейной интерполяции
def chart1():
    VY, VX, XJ = bigData()
    x = np.arange(0, 5.99, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, piecewiseLinearInterpolation(x), "-")
    plt.ylim(0, 3)
    plt.legend(["Исх.точки", "Кусочно-лин.интерпол."])
    plt.title("Кусочно-лин. интерпол.")
    plt.grid()
    plt.show()

# график сравнения кусочно-линейной и сплайн линейной интерполяций
def chart2():
    VY, VX, XJ = bigData()
    x = np.arange(0, 5.99, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, piecewiseLinearInterpolation(x), "#0000ff")
    plt.plot(x, splineLinearInterpolation(x), "#00ff00")
    plt.ylim(0, 3)
    plt.legend(["Исх.точки", "Кусочно-лин.", "Сплайн лин"])
    plt.title("Сравнение кусочно-линейной и сплайн линейной интерполяций")
    plt.grid()
    plt.show()

# сравнение 3 видов сплайн интерполяции
def chart3():
    VY, VX, XJ = bigData()
    x = np.arange(0, 5.99, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, splineLinearInterpolation(x), "#0000ff", linestyle="-")
    plt.plot(x, splineCubicInterpolation(x), "#00ff00", linestyle="--")
    plt.plot(x, splineParabolicInterpolation(x), "#ff00ff", linestyle=":")
    plt.ylim(0, 3)
    plt.legend(["Исх.точки", "Сплайн лин.", "Сплайн куб.", "Сплайн параб."])
    plt.title("Сравнение 3 видов сплайн интерполяций")
    plt.grid()
    plt.show()

# график интерполяции вне диапазона
def chart4():
    VY, VX, XJ = bigData()
    x = np.arange(0, 10, 0.01)
    range1, range2, range3 = calculationsOutARange()
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, splineLinearInterpolation(x), "#0000ff", linestyle="-")
    plt.plot(x, splineCubicExtrapolation(x), "#00ff00", linestyle="--")
    plt.plot(x, splineParabolicExtrapolation(x), "#ff00ff", linestyle=":")
    plt.plot(7, range1, "#00ffff", marker="*")
    plt.plot(7, range2, "#8000ff", marker=".")
    plt.plot(7, range3, "#008040", marker=".")
    plt.ylim(0, 3)
    plt.legend([
            "Исх. точки",
            "Сплайн лин.",
            "Сплайн куб.",
            "Сплайн параб.",
            "Лин.вне д.",
            "Куб.вне д.",
            "Параб.вне д."
        ])
    plt.title("Интерполяции вне диапазона")
    plt.grid()
    plt.show()

# тригонометрическая интерполяция (полный набор данных)
def chart5():
    VY, VX, XJ = bigData()
    x = np.arange(0, 10, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, trigonometricInterpolation(x), color="#ff8040")
    plt.ylim(0, 3)
    plt.legend(["Исх.точки", "Триг.итерпол."])
    plt.title("Тригонометрическая интерполяция полный набор данных")
    plt.grid()
    plt.show()

# Сравнение тригонометрической, параболической и кубической интерполяций
def chart6():
    VY, VX, XJ = bigData()
    x = np.arange(0, 10, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(x, trigonometricInterpolation(x), color="#ff8040", linewidth=1) #Тригонометрическая интерполяция
    plt.plot(x, splineParabolicExtrapolation(x), "#00ff00", linewidth=1) #Сплайн параболическая
    plt.plot(x, splineCubicExtrapolation(x), "#ff00ff", linewidth=1) #Сплайн кубическая
    plt.ylim(0, 3)
    plt.legend(["Исх.точки", "Триг.интерпол.", "Сплайн параб.", "Сплайн куб."])
    plt.title("Сравнение тригонометрич., параболич. и кубич. интерполяций")
    plt.grid()
    plt.show()

# расчет значений вне диапазона
def calculationsOutARange():
    range1 = splineLinearInterpolation(7)
    range3 = splineCubicExtrapolation(7)
    range2 = splineParabolicExtrapolation(7)
    return range1, range2, range3

chart1()
chart2()
chart3()
chart4()
chart5()
chart6()

