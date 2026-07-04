> mean(data2$Age)
[1] 9.931193
> mean(data2$Height)
[1] 61.14358
> age = mean(data2$Age)
>  attach(data2)
> mean(Age)
[1] 9.931193
> mean(Height)
[1] 61.14358
> detach(data2)
> age
[1] 9.931193
>  attach(data2)
> names(data2)
[1] "Age"    "Height" "Gender" "Smoke"  "FEV"   
> class(Age)
[1] "integer"
> class(FEV)
[1] "numeric"
> class(Height)
[1] "numeric"
> # IF you have factors use levels()
> summary(data2)
      Age             Height          Gender           Smoke        
 Min.   : 3.000   Min.   :46.00   Min.   :0.0000   Min.   :0.00000  
 1st Qu.: 8.000   1st Qu.:57.00   1st Qu.:0.0000   1st Qu.:0.00000  
 Median :10.000   Median :61.50   Median :1.0000   Median :0.00000  
 Mean   : 9.931   Mean   :61.14   Mean   :0.5138   Mean   :0.09939  
 3rd Qu.:12.000   3rd Qu.:65.50   3rd Qu.:1.0000   3rd Qu.:0.00000  
 Max.   :19.000   Max.   :74.00   Max.   :1.0000   Max.   :1.00000  
      FEV       
 Min.   :0.791  
 1st Qu.:1.981  
 Median :2.547  
 Mean   :2.637  
 3rd Qu.:3.119  
 Max.   :5.793  
> x = c(0,1,1,1,0,0,0,0,0,0)
> class(x)
[1] "numeric"
> summary(x)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
   0.00    0.00    0.00    0.30    0.75    1.00 
> x = as.factor(x)
> class(x)
[1] "factor"
> summary(x)
0 1 
7 3 