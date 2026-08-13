# Week 2 Summary: Valid Arguments & Quantified Statements

## Part 1: Valid vs Invalid Arguments

**Key idea:** An argument is **valid** if, whenever ALL the premises are true, the conclusion MUST also be true. It's not about whether the statements are actually true in real life — only about whether the *structure* guarantees the conclusion follows.

### The Strategy
1. **Hunt for a bad row first** (shortcut): try to find a valuation where all premises are true but the conclusion is false.
   - Found one? → **Invalid**. Stop — no need to check further.
2. **Can't find one easily?** → Build the full truth table and check every row.
   - No bad row anywhere? → **Valid**.

### The asymmetry (important!)
| Situation | What it proves |
|---|---|
| All premises True, conclusion False (in some row) | **Invalid** — done immediately |
| All premises True, conclusion True (in some row) | Proves nothing on its own — must check ALL rows |
| At least one premise False (in a row) | Irrelevant — that row doesn't count either way |

To conclude **valid**, you must rule out bad rows in *every single row* of the table. To conclude **invalid**, *one* bad row is enough.

### Common Valid Rules of Inference
| Rule | Form |
|---|---|
| Modus Ponens | `p → q`, `p` ∴ `q` |
| Modus Tollens | `p → q`, `~q` ∴ `~p` |
| Disjunctive Syllogism | `p ∨ q`, `~p` ∴ `q` |
| Hypothetical Syllogism | `p → q`, `q → r` ∴ `p → r` |
| Simplification | `p ∧ q` ∴ `p` |
| Conjunction | `p`, `q` ∴ `p ∧ q` |
| Addition | `p` ∴ `p ∨ q` |

### Common Fallacies (look valid, but AREN'T)
| Fallacy | Form | Why it fails |
|---|---|---|
| Affirming the Consequent | `p → q`, `q` ∴ `p` | `q` could be true for other reasons |
| Denying the Antecedent | `p → q`, `~p` ∴ `~q` | `q` could still be true another way |

---

## Part 2: Quantified Statements & Negation

### Negation rules
- `~∀x P(x) ≡ ∃x ~P(x)` (negating "for all" gives "there exists... not")
- `~∃x P(x) ≡ ∀x ~P(x)`
- `~(A → B) ≡ A ∧ ~B` (negating an implication: keep hypothesis, negate conclusion, join with AND)

### To disprove a `∀x, P(x)` statement
Find just **ONE** counterexample where `P(x)` is false. That's enough.

### To disprove a `∀x, P(x) → Q(x)` statement
Find just **ONE** value of x where `P(x)` is TRUE but `Q(x)` is FALSE.

---

## Practice Questions (worked)

### Q1. Is this valid?
```
p → q
p ∨ r
p ∨ ~r
∴ q
```
**Answer: Valid.**
`p∨r` and `p∨~r` together force `p = T` (if p were false, you'd need both r and ~r true — impossible). Once `p = T`, premise `p→q` forces `q = T`. So every row where all premises are true also has `q = T`. No bad row exists.

### Q2. Is this valid?
```
p → q
p ∨ r
p ∨ ~r
∴ ~q
```
**Answer: Invalid.**
Same premises as Q1 force `p = T, q = T` in every "premises-true" row. But now the conclusion is `~q`, which is **False** in those rows.
Bad row: `p=T, q=T, r=T` → all premises True, `~q` = False. Invalid.

### Q3. Is this valid?
```
p → ~r
r ∨ ~q
q
∴ ~p
```
**Answer: Valid** (proof by inference rules, not truth table):
1. `p → ~r` — premise
2. `r ∨ ~q` — premise
3. `q` — premise
4. `~q ∨ r` — from (2), commutativity
5. `q → r` — from (4), rewriting `∨` as `→`
6. `r` — from (3) and (5), Modus Ponens
7. `~(~r)` — from (6), double negation
8. `~p` — from (1) and (7), Modus Tollens

### Q4. Is this argument valid? "I like mathematics or I like history. I do not like history. Therefore, I like mathematics."
**Answer: Valid** — this is exactly Disjunctive Syllogism (`m ∨ h`, `~h` ∴ `m`).

### Q5. Is this argument valid? "If I am studying mathematics, then I am happy. I am happy. Therefore, I am studying mathematics."
**Answer: Invalid** — this is Affirming the Consequent (`p → h`, `h` ∴ `p`).
Counterexample: `p = F, h = T`. Then `p→h = T` ✓, `h = T` ✓, but `p = F` ✗.

### Q6. True or false? ∀x ∈ ℤ, if 6 is divisible by x, then x = 2.
**Answer: False.**
Counterexample: `x = 3`. 6 is divisible by 3 (hypothesis true), but `x ≠ 2` (conclusion false).

### Q7. Negate and determine truth: ∀x ∈ ℝ, (x² ≥ x) → (x ≥ 0)
**Negation:** `∃x ∈ ℝ, (x² ≥ x) ∧ (x < 0)`
**Answer: Original is False, negation is True.**
Witness: `x = -1`. `x² = 1 ≥ -1` ✓, and `-1 < 0` ✓.

### Q8. Negate and determine truth: ∀x,y ∈ ℝ, if x+y ∈ ℤ and x−y ∈ ℤ then x ∈ ℤ
**Negation:** `∃x,y ∈ ℝ, (x+y ∈ ℤ) ∧ (x−y ∈ ℤ) ∧ (x ∉ ℤ)`
**Answer: Original is False, negation is True.**
Witness: `x = 0.5, y = 0.5`. `x+y = 1 ∈ ℤ` ✓, `x−y = 0 ∈ ℤ` ✓, but `x = 0.5 ∉ ℤ` ✓.

---

## Try These Yourself (no answers given — test yourself)

1. Is this valid? `p → q`, `~p` ∴ `~q`
2. Is this valid? `p ∨ q`, `p → r`, `q → r` ∴ `r`
3. Negate: ∀x ∈ ℝ, if x > 2 then x² > 4. Which is true — the statement or its negation?
4. "If it snows, school is cancelled. School is not cancelled. Therefore it did not snow." — Valid or invalid, and which rule/fallacy is this?