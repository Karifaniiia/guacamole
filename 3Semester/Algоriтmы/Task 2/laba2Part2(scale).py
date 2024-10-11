import math
import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate

def bigData():
    n = 10
    i = np.arange(0, 2 * n + 1)
    VY = [1.0, 1.34, 1.75, 2.18, 2.53, 2.71, 2.65, 2.37, 1.97, 1.54, 1.16, 0.86, 0.64, 0.5, 0.42, 0.37, 0.36, 0.39, 0.45, 0.56, 0.74]
    VX = 2 * math.pi * i / (2 * n + 1)
    return VY, VX

# Кусочно-линейная интерполяция
def piecewiseLinearInterpolation(x):
    VY, VX = bigData()
    f = interpolate.interp1d(VX, VY, kind='linear', fill_value='extrapolate')
    return f(x)

# Сплайн-линейная интерполяция
def splineLinearInterpolation(x):
    VY, VX = bigData()
    C = interpolate.splrep(VX, VY)
    spl = interpolate.splev(x, C)
    return spl

# Сплайн-кубическая интерполяция
def splineCubicInterpolation(x):
    VY, VX = bigData()
    f = interpolate.interp1d(VX, VY, 'cubic', fill_value='extrapolate')
    return f(x)

# Сплайн-параболическая интерполяция
def splineParabolicInterpolation(x):
    VY, VX = bigData()
    f = interpolate.interp1d(VX, VY, kind='quadratic', fill_value='extrapolate')
    return f(x)

def scale():
    VY, VX = bigData()
    X1 = []

    scale1 = 15
    j = 0
    while j < (scale1 + 1):
        X1.append(min(VX) + j * ((max(VX) - min(VX)) / scale1))
        j = j + 1
    X2 = []

    scale2 = 50
    j = 0
    while j < (scale2 + 1):
        X2.append(min(VX) + j * ((max(VX) - min(VX)) / scale2))
        j = j + 1
    X3 = []

    scale3 = 100
    j = 0
    while j < (scale3 + 1):
        X3.append(min(VX) + j * ((max(VX) - min(VX)) / scale3))
        j = j + 1
    return X1, X2, X3

# линейная
def chart7():
    VY, VX = bigData()
    X1, X2, X3 = scale()
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(X1, piecewiseLinearInterpolation(X1), '#0000ff', linewidth=1.5)
    plt.plot(X2, piecewiseLinearInterpolation(X2), '#00ff00', linewidth=1.5)
    plt.plot(X3, piecewiseLinearInterpolation(X3), '#ff00ff', linestyle="--", linewidth=1.5)
    plt.xlim(0, 6)
    plt.ylim(0, 3)
    plt.legend(['Исх.точки', 'scale 15', 'scale 50', 'scale 100'])
    plt.title('Линейная при scale = 15, 50, 100')
    plt.grid()
    plt.show()

# кубическая
def chart8():
    VY, VX = bigData()
    X1, X2, X3 = scale()
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(X1, splineCubicInterpolation(X1), '#0000ff', linewidth=1.5)
    plt.plot(X2, splineCubicInterpolation(X2), '#00ff00', linewidth=1.5)
    plt.plot(X3, splineCubicInterpolation(X3), '#ff00ff', linestyle="--", linewidth=1.5)
    plt.xlim(0, 6)
    plt.ylim(0, 3)
    plt.legend(['Исх.точки', 'scale 15', 'scale 50', 'scale 100'])
    plt.title('Кубическая при scale = 15, 50, 100')
    plt.grid()
    plt.show()

# параболическая
def chart9():
    VY, VX = bigData()
    X1, X2, X3 = scale()
    plt.plot(VX, VY, "ro", markersize=5)
    plt.plot(X1, splineParabolicInterpolation(X1), '#0000ff', linewidth=1.5)
    plt.plot(X2, splineParabolicInterpolation(X2), '#00ff00', linewidth=1.5)
    plt.plot(X3, splineParabolicInterpolation(X3), '#ff00ff', linestyle="--", linewidth=1.5)
    plt.xlim(0, 6)
    plt.ylim(0, 3)
    plt.legend(['Исх.точки', 'scale 15', 'scale 50', 'scale 100'])
    plt.title('Параболическая при scale = 15, 50, 100')
    plt.grid()
    plt.show()

chart7()
chart8()
chart9()
