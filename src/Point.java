public class Point implements Cloneable {
    private float[] data;

    public Point(float[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Coordinates cannot be null."); // ★坐标不能为空
        }
        if (data.length != 2) {
            throw new IllegalArgumentException("Point dimension should be 2."); // ★点的维度必须为2
        }

        this.data = new float[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length); // 复制数组
    }

    public Point(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Coordinates cannot be null."); // ★坐标不能为空
        }
        if (data.length != 2) {
            throw new IllegalArgumentException("Point dimension should be 2."); // ★点的维度必须为2
        }

        this.data = new float[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i]; // 复制数组
        }
    }

    @Override // 重写clone接口
    protected Object clone() {
        float[] copy = new float[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return new Point(copy);
    }

    @Override // 重写tostring（）方法
    public String toString() {
        StringBuffer sBuffer = new StringBuffer("(");

        for (int i = 0; i < data.length - 1; i++) {
            sBuffer.append(data[i]).append(",");
        }

        sBuffer.append(data[data.length - 1]).append(")"); // 最后一位数据后面不再添加逗号，追加放在循环外面

        return sBuffer.toString();
    }

    /**
     * @param index
     * @return 返回Point坐标第i位的float值
     */
    public float getFloatCoordinate(int index) {
        return data[index];
    }

    /**
     * @param index
     * @return 返回Point坐标第i位的int值
     */
    public int getIntCoordinate(int index) {
        return (int) data[index];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) // 如果obj是point的实例
        {
            Point point = (Point) obj;

            for (int i = 0; i < 2; i++) {
                if (getFloatCoordinate(i) != point.getFloatCoordinate(i))
                    return false;
            }
        }

        if (!(obj instanceof Point))
            return false;

        return true;
    }
}