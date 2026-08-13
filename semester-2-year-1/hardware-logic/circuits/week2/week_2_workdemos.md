# CSSE2010 Week 2 — Worked Examples Supplement

Pairs with the main cheat sheet. Where that file gives you the *pattern*, this one shows the pattern actually run through, start to finish.

## 1. Encoder (Q16 — the one we skipped)

**Problem:** 4 input lines, exactly one high at any instant. 2 output lines whose binary value tells you which input is high.

**Function table:**

| Input high | High-order bit | Low-order bit |
|---|---|---|
| 0 | 0 | 0 |
| 1 | 0 | 1 |
| 2 | 1 | 0 |
| 3 | 1 | 1 |

**The trick:** since exactly one input is ever high, you don't need full SOP logic with AND gates — you just need to know "is input 1 OR input 3 high?" for the low bit, and "is input 2 OR input 3 high?" for the high bit. Because only one input is ever active, an OR gate is enough (no risk of two inputs firing at once and corrupting the result).

- **Low-order bit** = input1 OR input3 (both have low bit = 1 in the table)
- **High-order bit** = input2 OR input3 (both have high bit = 1 in the table)

Circuit: just 2 OR gates, each taking 2 of the 4 inputs. No AND gates, no inverters needed — simplest circuit of the whole worksheet, precisely *because* of the "exactly one input high" guarantee.

## 2. Full worked truth table — Q6's 4-variable function

**F = XY′Z + X′Y′Z + W′XY + WX′Y + WXY**

Go row by row, W X Y Z from 0000 to 1111. For each row, check whether it satisfies any of the 5 terms.

| W X Y Z | Check | F |
|---|---|---|
| 0000 | none match | 0 |
| 0001 | X′Y′Z ✓ (X=0,Y=0,Z=1) | 1 |
| 0010 | none | 0 |
| 0011 | none | 0 |
| 0100 | none (need Z=1 for XY′Z) | 0 |
| 0101 | XY′Z ✓ (X=1,Y=0,Z=1) | 1 |
| 0110 | W′XY ✓ (W=0,X=1,Y=1) | 1 |
| 0111 | W′XY ✓ | 1 |
| 1000 | none | 0 |
| 1001 | X′Y′Z ✓ | 1 |
| 1010 | WX′Y ✓ (W=1,X=0,Y=1) | 1 |
| 1011 | WX′Y ✓ | 1 |
| 1100 | none | 0 |
| 1101 | XY′Z ✓ | 1 |
| 1110 | WXY ✓ (W=1,X=1,Y=1) | 1 |
| 1111 | WXY ✓ | 1 |

**Checksum trick:** each 3-literal term covers exactly 2 rows (the 4th variable is free). 5 terms × 2 rows = 10 rows of F=1, IF no overlaps. Matches the count above (10 ones, 6 zeros) — this is how you sanity-check your own table fast without rechecking every row.

## 3. Full derivation — full adder SOP → simplified

**Starting SOP (from minterms where output=1):**

- S = A′B′Cin + A′BCin′ + AB′Cin′ + ABCin
- Cout = A′BCin + AB′Cin + ABCin′ + ABCin

**Simplifying Cout, step by step:**

1. Group the last two terms (share AB): `ABCin′ + ABCin = AB(Cin′+Cin) = AB`
2. Now: `Cout = A′BCin + AB′Cin + AB`
3. Rewrite AB using Cin: `AB = ABCin + ABCin′` (expand it back out temporarily)
4. Pair `ABCin` with `A′BCin` (share BCin): `A′BCin + ABCin = BCin(A′+A) = BCin`
5. Pair `AB′Cin` with `ABCin′`... actually simpler — just recombine directly: `A′BCin + AB′Cin + AB = AB + ACin + BCin` (standard majority-function result — same as Q3's "at least 2 of A,B,C are true" function from lecture)

**Result:** `Cout = AB + ACin + BCin` — this is literally the 3-input majority function from lecture (true when ≥2 inputs are true), which matches the "Cout=1 when ≥2 of A,B,Cin are 1" shortcut from the main cheat sheet.

**S doesn't reduce further** — it's inherently `A⊕B⊕Cin`, the odd-parity function. If you try to factor it like Cout, you'll find every grouping attempt fails to combine, because XOR-type functions don't have redundant literals to cancel — that itself is worth recognizing: not everything simplifies, and repeatedly failing to find a common factor is itself useful information (you've likely hit an XOR/odd function).

## 4. Two's complement arithmetic — one fully worked example

**00101101 + 01101111** (from Q1)

```
  00101101
+ 01101111
-----------
  10011100
```

Add right to left like normal binary addition, carrying as needed. Then check for overflow:

- Both operands are positive (leading bit 0).
- Result's leading bit is 1 → result reads as negative.
- **Positive + positive = negative → overflow occurred.**

Convert to decimal to verify: `00101101` = 45, `01101111` = 111. 45+111 = 156. But 8-bit two's complement can only represent -128 to +127 — 156 is out of range, confirming the overflow.