# Frequency Count

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Dravid', 'Sehwag'],
    'Format': ['ODI', 'Test', 'Test', 'ODI', 'ODI']
})

pd.crosstab(df['Player'], df['Format'])

# Shows how many times each player appeared in each format.

--------------------------------------------------------------------------------------------

# Aggregation (values + aggfunc)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Dravid'],
    'Format': ['ODI', 'Test', 'ODI', 'ODI'],
    'Runs': [100, 120, 80, 70]
})

pd.crosstab(df['Player'], df['Format'], values=df['Runs'], aggfunc='sum')


--------------------------------------------------------------------------------------------

# Normalize (percentage)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Dravid'],
    'Format': ['ODI', 'Test', 'ODI', 'ODI'],
    'Runs': [100, 120, 80, 70]
})

pd.crosstab(df['Player'], df['Format'], normalize='index')


--------------------------------------------------------------------------------------------

# With multiple levels

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Dravid'],
    'Format': ['ODI', 'Test', 'ODI', 'ODI'],
    'Runs': [100, 120, 80, 70]
})

pd.crosstab([df['Player'], df['Format']], df['Runs'] > 90)

--------------------------------------------------------------------------------------------

# margins=True

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sachin', 'Dravid', 'Sehwag'],
    'Format': ['ODI', 'Test', 'Test', 'ODI', 'ODI']
})

pd.crosstab(df['Player'], df['Format'], margins=True)