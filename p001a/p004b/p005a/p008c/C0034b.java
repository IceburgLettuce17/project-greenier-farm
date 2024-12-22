package p001a.p004b.p005a.p008c;

public final class C0034b<E> {

    private static final Object f86aB = new Object();

    private boolean f87aC;

    private int[] f88aD;

    private Object[] f89aE;

    private int f90aF;

    public C0034b() {
        this(10);
    }

    private C0034b(int i) {
        this.f87aC = false;
        int m105g = m105g(10);
        this.f88aD = new int[m105g];
        this.f89aE = new Object[m105g];
        this.f90aF = 0;
    }

    private static int binarySearch(int[] iArr, int i, int i2, int i3) {
        int i4 = -1;
        int i5 = i2 + 0;
        while (i5 - i4 > 1) {
            int i6 = (i5 + i4) / 2;
            if (iArr[i6] < i3) {
                i4 = i6;
            } else {
                i5 = i6;
            }
        }
        return i5 == i2 + 0 ? (i2 + 0) ^ (-1) : iArr[i5] != i3 ? i5 ^ (-1) : i5;
    }

    private static int m105g(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private void m106gc() {
        int i = this.f90aF;
        int[] iArr = this.f88aD;
        Object[] objArr = this.f89aE;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f86aB) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.f87aC = false;
        this.f90aF = i2;
    }

    public final void clear() {
        int i = this.f90aF;
        Object[] objArr = this.f89aE;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f90aF = 0;
        this.f87aC = false;
    }

    public final E get(int i) {
        int binarySearch = binarySearch(this.f88aD, 0, this.f90aF, i);
        if (binarySearch < 0 || this.f89aE[binarySearch] == f86aB) {
            return null;
        }
        return (E) this.f89aE[binarySearch];
    }

    public final int keyAt(int i) {
        if (this.f87aC) {
            m106gc();
        }
        return this.f88aD[i];
    }

    public final void put(int i, E e) {
        int binarySearch = binarySearch(this.f88aD, 0, this.f90aF, i);
        if (binarySearch >= 0) {
            this.f89aE[binarySearch] = e;
            return;
        }
        int i2 = binarySearch ^ (-1);
        if (i2 < this.f90aF && this.f89aE[i2] == f86aB) {
            this.f88aD[i2] = i;
            this.f89aE[i2] = e;
            return;
        }
        if (this.f87aC && this.f90aF >= this.f88aD.length) {
            m106gc();
            i2 = binarySearch(this.f88aD, 0, this.f90aF, i) ^ (-1);
        }
        if (this.f90aF >= this.f88aD.length) {
            int m105g = m105g(this.f90aF + 1);
            int[] iArr = new int[m105g];
            Object[] objArr = new Object[m105g];
            System.arraycopy(this.f88aD, 0, iArr, 0, this.f88aD.length);
            System.arraycopy(this.f89aE, 0, objArr, 0, this.f89aE.length);
            this.f88aD = iArr;
            this.f89aE = objArr;
        }
        if (this.f90aF - i2 != 0) {
            System.arraycopy(this.f88aD, i2, this.f88aD, i2 + 1, this.f90aF - i2);
            System.arraycopy(this.f89aE, i2, this.f89aE, i2 + 1, this.f90aF - i2);
        }
        this.f88aD[i2] = i;
        this.f89aE[i2] = e;
        this.f90aF++;
    }

    public final void remove(int i) {
        int binarySearch = binarySearch(this.f88aD, 0, this.f90aF, i);
        if (binarySearch < 0 || this.f89aE[binarySearch] == f86aB) {
            return;
        }
        this.f89aE[binarySearch] = f86aB;
        this.f87aC = true;
    }

    public final void removeAt(int i) {
        if (this.f89aE[i] != f86aB) {
            this.f89aE[i] = f86aB;
            this.f87aC = true;
        }
    }

    public final int size() {
        if (this.f87aC) {
            m106gc();
        }
        return this.f90aF;
    }

    public final E valueAt(int i) {
        if (this.f87aC) {
            m106gc();
        }
        return (E) this.f89aE[i];
    }
}
