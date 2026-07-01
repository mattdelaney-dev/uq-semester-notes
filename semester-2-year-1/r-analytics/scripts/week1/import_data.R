> help("read.csv")
> 
> data1 = read.csv(file.choose(), header=T)
> data1
    Age Height Gender Smoke   FEV
1     9   57.0      0     0 1.708
2     8   67.5      0     0 1.724
3     7   54.5      0     0 1.720
4     9   53.0      1     0 1.558
5     9   57.0      1     0 1.895
6     8   61.0      0     0 2.336
7     6   58.0      0     0 1.919
8     6   56.0      0     0 1.415
9     8   58.5      0     0 1.987
10    9   60.0      0     0 1.942
 [ reached 'max' / getOption("max.print") -- omitted 454 rows ]
> 
> data 2 = read.table(file.choose(), header=T, sep=",")
Error: unexpected numeric constant in "data 2"

> data2 = read.table(file.choose(), header=T, sep=",")
> data2
    Age Height Gender Smoke   FEV
1     9   57.0      0     0 1.708
2     8   67.5      0     0 1.724
3     7   54.5      0     0 1.720
4     9   53.0      1     0 1.558
5     9   57.0      1     0 1.895
6     8   61.0      0     0 2.336
7     6   58.0      0     0 1.919
8     6   56.0      0     0 1.415
9     8   58.5      0     0 1.987
10    9   60.0      0     0 1.942
 [ reached 'max' / getOption("max.print") -- omitted 454 rows ]