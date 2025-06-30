# Sort by a single column

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

df.sort_values(by='Age', inplace=True)  # Ascending order by default

---------------------------------------------------------------------------

# Sort in descending order

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

df.sort_values(by='Runs', ascending=False, inplace=True)

---------------------------------------------------------------------------

# Sort by a single column

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

df.sort_values(by='Age', inplace=True)

---------------------------------------------------------------------------

# Sort by multiple columns

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

df.sort_values(by=['Age', 'Runs'], ascending=[True, False], inplace=True)

---------------------------------------------------------------------------

# Sort by index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

df.sort_index(inplace=True)         # Sort rows by index
df.sort_index(axis=1, inplace=True) # Sort columns alphabetically

---------------------------------------------------------------------------

# Return a sorted copy without changing original

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

sorted_df = df.sort_values(by='Name')

---------------------------------------------------------------------------

# Sort by length of Name

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Role': ['Batsman', 'Opener', 'Captain', 'Batsman']
})

df['NameLength'] = df['Name'].apply(len)
df = df.sort_values(by='NameLength')

df.drop('NameLength', axis=1, inplace=True)
---------------------------------------------------------------------------

# Custom sort order (e.g. Role priority)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Role': ['Batsman', 'Opener', 'Captain', 'Batsman']
})

role_order = {'Captain': 0, 'Opener': 1, 'Batsman': 2}

df['RoleOrder'] = df['Role'].map(role_order)

df = df.sort_values(by='RoleOrder')

df.drop('RoleOrder', axis=1, inplace=True)
---------------------------------------------------------------------------

# Sort by multiple custom logics

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Role': ['Batsman', 'Opener', 'Captain', 'Batsman']
})

df['NameLength'] = df['Name'].apply(len)
df['RoleOrder'] = df['Role'].map(role_order)

df = df.sort_values(by=['RoleOrder', 'NameLength', 'Age'], ascending=[True, True, False])

df.drop(['NameLength', 'RoleOrder'], axis=1, inplace=True)
---------------------------------------------------------------------------

# Sort and return just one column

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

result = df.sort_values(by='Runs', ascending=False)['Name']
print(result)
---------------------------------------------------------------------------

# Sort by Age and return only Runs

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

result = df.sort_values(by='Age')['Runs']
print(result)

---------------------------------------------------------------------------

# Get top N values (e.g. top 2 scorers)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

top_scorers = df.sort_values(by='Runs', ascending=False)['Name'].head(2)
print(top_scorers)
---------------------------------------------------------------------------

# Convert to list or array (optional)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

names_sorted_by_runs = df.sort_values(by='Runs')['Name'].tolist()

---------------------------------------------------------------------------

# nlargest(n, column_name) - Only works on numeric columns

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

top_players = df.nlargest(2, 'Runs')
print(top_players)
---------------------------------------------------------------------------

# nlargest Return only one column:

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

top_names = df.nlargest(2, 'Runs')['Name']
print(top_names)
---------------------------------------------------------------------------

#nsmallest

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8500, 10000, 11000]
})

bottom_players = df.nsmallest(2, 'Runs')
print(bottom_players)
