Stream.of(
Block.createCuboidShape(4, 0, 1, 13, 1, 15),
Block.createCuboidShape(5, 1, 2, 12, 18, 14),
Block.createCuboidShape(6, 18, 3, 11, 19, 13)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();