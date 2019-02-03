# RTree
Point代表数据点，包含二维坐标（可以扩展）和文本信息。
Rectangle代表生成矩形，由左下角和右上角两个顶点确定。
RTNode是抽象类，在此基础上定义了RTDataNode叶节点和RTDirNode中间节点。
RTree包含节点容量、根节点等信息。
插入、删除以及查找在RTNode中实现。
