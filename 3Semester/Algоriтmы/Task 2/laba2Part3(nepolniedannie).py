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

# неполный набор данных
def smallData():
    vy = [1.0, 1.75, 2.53, 2.65, 1.97, 1.16, 0.64, 0.42, 0.36, 0.45, 0.74]
    vx = [
        0,
        0.598399,
        1.196797,
        1.795196,
        2.393594,
        2.991993,
        3.590392,
        4.18879,
        4.787189,
        5.385587,
        5.983986
    ]
    xj = []
    scale = 100
    j = 0
    while j < scale:
        xj.append(min(vx) + j * (max(vx)-min(vx)) / scale)
        j = j + 1
    return vy, vx, xj

# тригонометрическая интерполяция полный набор данных
def trigonometricInterpolationBigData(x):
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

# тригонометрическая интерполяция неполный набор данных
def trigonometricInterpolationSmallData(x):
    VY, VX, XJ = smallData()
    n = 10
    i = 0
    a0 = 0
    while i < n + 1:
        a0 += VY[i]
        i = i + 1
    a0 = a0 / (2 * n + 1)
    k = 1
    ak = []
    bk = []
    while k < n + 1:
        a = b = 0
        i = 0
        while i < n + 1:
            a += VY[i] * math.cos((k * i * 2 * math.pi) / (2 * n + 1))
            b += VY[i] * math.sin((k * i * 2 * math.pi) / (2 * n + 1))
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
            p += ak[k1] * math.cos((k * x[i]) / 2)
            p1 += bk[k1] * math.sin((k * x[i]) / 2)
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

# сплайн-кубическая интерполяция (полный набор)
def splineCubicInterpolationBigData(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, "cubic")
    return f(x)

# сплайн-кубическая интерполяция (неполный набор)
def splineCubicInterpolationSmallData(x):
    VY, VX, XJ = smallData()
    f = interpolate.interp1d(VX, VY, "cubic")
    return f(x)

# сплайн-параболическая интерполяция
def splineParabolicInterpolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="quadratic")
    return f(x)

# кусочно-линейная экстраполяция
def piecewiseLinearExtrapolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="linear", fill_value="extrapolate")
    return f(x)

# сплайн-кубическая экстраполяция (полный набор данных)
def splineCubicExtrapolationBigData(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, "cubic", fill_value="extrapolate")
    return f(x)

# сплайн-кубическая экстраполяция (неполный набор данных)
def splineCubicExtrapolationSmallData(x):
    VY, VX, XJ = smallData()
    f = interpolate.interp1d(VX, VY, "cubic", fill_value="extrapolate")
    return f(x)

# сплайн-параболическая экстраполяция
def splineParabolicExtrapolation(x):
    VY, VX, XJ = bigData()
    f = interpolate.interp1d(VX, VY, kind="quadratic", fill_value="extrapolate")
    return f(x)

# Тригонометрическая интерполяция (неполный набор данных)
def chart10():
    vy, vx, xj = smallData()
    x = np.arange(0, 8, 0.01)
    plt.plot(vx, vy, "bo", markersize=5)
    plt.plot(x, trigonometricInterpolationSmallData(x), color="#ff8040", linewidth=1.5)
    plt.ylim(-1, 3)
    plt.legend(["Исх.точки", "Точки через одну", "Триг. при н.н"])
    plt.title("Тригонометрическая интерполяция неполный набор данных")
    plt.grid()
    plt.show()

# Тригонометрическая сравнение полный и неполный
def chart11():
    VY, VX, XJ = bigData()
    vy, vx, xj = smallData()
    x = np.arange(0, 8, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(vx, vy, "bo", markersize=5)
    plt.plot(x, trigonometricInterpolationBigData(x), color="#00ff00", linewidth=1.5)
    plt.plot(x, trigonometricInterpolationSmallData(x), color="#ff8040", linewidth=1.5)
    plt.ylim(-1, 3)
    plt.legend(["Исх.точки", "Точки через одну", "Триг.п.н", "Триг.н.н"])
    plt.title("Тригонометрическая сравнение полный и неполный")
    plt.grid()
    plt.show()

# Кубическая сравнение полный и неполный
def chart12():
    VY, VX, XJ = bigData()
    vy, vx, xj = smallData()
    x = np.arange(0, 8, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(vx, vy, "bo", markersize=5)
    plt.plot(x, splineCubicExtrapolationBigData(x), color="#00ff00", linewidth=1.5)
    plt.plot(x, splineCubicExtrapolationSmallData(x), color="#ff80ff", linewidth=1.5)
    plt.ylim(-1, 3)
    plt.legend(["Исх.точки", "Точки через одну", "Куб.п.н", "Куб.н.н"])
    plt.title("Кубическая сравнение полный и неполный")
    plt.grid()
    plt.show()

# Сравнение тригонометрической с кубической
def chart13():
    VY, VX, XJ = bigData()
    vy, vx, xj = smallData()
    x = np.arange(0, 8, 0.01)
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(vx, vy, "bo", markersize=5)
    plt.plot(x, trigonometricInterpolationSmallData(x), color="#ff8000", linewidth=1.5)
    plt.plot(x, splineCubicExtrapolationSmallData(x), color="#ff80ff", linewidth=1.5)
    plt.ylim(-1, 3)
    plt.legend(["Исх.точки", "Точки через одну", "Триг.н.н", "Куб.н.н"])
    plt.title("Сравнение тригонометрической с кубической")
    plt.grid()
    plt.show()


chart10()
chart11()
chart12()
chart13()
