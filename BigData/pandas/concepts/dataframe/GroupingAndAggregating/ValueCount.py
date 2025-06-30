import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sachin', 'Sehwag', 'Dravid', 'Sachin']
})

# Count how many times each name appears
counts = df['Name'].value_counts()
print(counts)

-------------------------------------------------------------------------------------

# Sort by label instead

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sachin', 'Sehwag', 'Dravid', 'Sachin']
})

counts = df['Name'].value_counts(sort=False)

print(counts)

------------------------------------------------------------------------------------

# Normalize (get percentage instead of count)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sachin', 'Sehwag', 'Dravid', 'Sachin']
})

counts = df['Name'].value_counts(normalize=True)

print(counts)

-------------------------------------------------------------------------------------

# Include missing values (NaN)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sachin', 'Sehwag', 'Dravid', 'Sachin']
})

df['Name'].value_counts(dropna=False)

print(counts)

-------------------------------------------------------------------------------------

# Count Player frequency within each Team (grouped value_counts)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Sehwag', 'Dravid', 'Sachin'],
    'Team': ['India', 'India', 'India', 'India', 'India', 'Asia XI']
})

counts = df.groupby('Team')['Player'].value_counts()

print(counts)

