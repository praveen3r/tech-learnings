# Basic Example

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

print(df)

df_melted = pd.melt(df, id_vars='Player', var_name='Format', value_name='Runs')
print(df_melted)


------------------------------------------------------------------------------

Parameters of melt()

Parameter	            Description

id_vars         	Columns to keep as is
value_vars	        Columns to unpivot (default: all others)
var_name	        Name for new variable/column names
value_name	        Name for new values

------------------------------------------------------------------------------

# Melt with subset of columns:

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

print(df)

df_melted = pd.melt(df, id_vars='Player', value_vars=['ODI'], var_name='Format')
print(df_melted)

------------------------------------------------------------------------------

# Flattening pivot tables for analysis

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'India_ODI': [10000, 8000],
    'India_Test': [9000, 9500],
    'Asia_ODI': [2000, 1500],
    'Asia_Test': [3000, 2500]
})

print(df)

df_melted = pd.melt(df, id_vars='Player', var_name='Format', value_name='Runs')

print(df_melted)

# Then split Format into Team and MatchType using:

df_long[['Team', 'Type']] = df_long['Format'].str.split('_', expand=True)

------------------------------------------------------------------------------

# MultiIndex DataFrame

import pandas as pd

# Sample multi-indexed columns
tuples = [('India', 'ODI'), ('India', 'Test'), ('Australia', 'ODI'), ('Australia', 'Test')]
columns = pd.MultiIndex.from_tuples(tuples, names=['Team', 'Format'])

df = pd.DataFrame([
    [18426, 15921, 12000, 9000],
    [10889, 13288, 9500, 8000]
], columns=columns, index=['Sachin', 'Dravid'])

print(df)

df_melted = df.stack(level=[0, 1]).reset_index()
df_melted.columns = ['Player', 'Team', 'Format', 'Runs']

print(df_melted)


------------------------------------------------------------------------------

# stack - Basic Example

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

df.set_index('Player', inplace=True)
print(df)

stacked = df.stack()
print(stacked)


------------------------------------------------------------------------------

# unstack() — Rows to Columns

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

df.set_index('Player', inplace=True)
print(df)

stacked = df.stack()
print(stacked)

unstacked = stacked.unstack()
print(unstacked)

------------------------------------------------------------------------------

# Unstack by Level (MultiIndex)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

df.set_index('Player', inplace=True)
print(df)

stacked = df.stack()
print(stacked)

df.unstack(level=1)  # Bring 'ODI' and 'Test' back as columns


------------------------------------------------------------------------------

# MultiIndex Columns → Rows with stack()

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

df.set_index('Player', inplace=True)
print(df)

df.columns = pd.MultiIndex.from_tuples([('India', 'ODI'), ('India', 'Test')])

df = df.stack()

------------------------------------------------------------------------------

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid'],
    'ODI': [18426, 10889],
    'Test': [15921, 13288]
})

print(df)

df_melted = pd.melt(df, id_vars='Player', var_name='Format', value_name='Runs')
print(df_melted)

------------------------------------------------------------------------------

# Year-wise Runs Scored by Players

import pandas as pd

# Create a multi-indexed DataFrame
data = {
    ('2019', 'Runs'): [800, 600, 900],
    ('2019', 'Matches'): [15, 12, 18],
    ('2020', 'Runs'): [850, 700, 920],
    ('2020', 'Matches'): [14, 13, 19]
}

df = pd.DataFrame(data, index=['Sachin', 'Dravid', 'Sehwag'])
df.columns = pd.MultiIndex.from_tuples(df.columns)
print(df)

stacked_df = df.stack(level=0)
print(stacked_df)

unstacked_df = stacked_df.unstack(level=1)
print(unstacked_df)

# Access individual years or metrics

df[('2020', 'Runs')]        # All runs in 2020
df.xs('Runs', axis=1, level=1)  # All years' runs
stacked_df.loc['Sachin']    # Sachin's all years