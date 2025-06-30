# Filter rows by a single condition

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[df['Age'] > 30])

--------------------------------------------------------------------------------

# Filter with multiple conditions

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[(df['Age'] > 30) & (df['Name'] == 'Ganguly')])

--------------------------------------------------------------------------------

# OR condition

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[(df['Age'] > 30) | (df['Name'] == 'Ganguly')])

--------------------------------------------------------------------------------

# Filter using .isin()

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[df['Name'].isin(['Sachin', 'Ganguly'])])

--------------------------------------------------------------------------------

# Filter using .str.contains() for text

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[df['Name'].str.contains('a')])

--------------------------------------------------------------------------------

# Filter using .query() (optional syntax)

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.query("Age > 30 and Name == 'Ganguly'"))

--------------------------------------------------------------------------------

# Filter with loc and one condition

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

result = df.loc[df['Age'] > 30, ['Name', 'Age']]
print(result)

--------------------------------------------------------------------------------

# Multiple conditions using loc

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8000, 10000, 11000]
}

df = pd.DataFrame(data)

result = df.loc[(df['Age'] > 30) & (df['Runs'] > 10000), ['Name', 'Age', 'Runs']]
print(result)

--------------------------------------------------------------------------------

# Filter rows and return all columns

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32],
    'Runs': [12000, 8000, 10000, 11000]
}

df = pd.DataFrame(data)

result = df.loc[df['Age'] < 30]
print(result)

--------------------------------------------------------------------------------

# 

--------------------------------------------------------------------------------

# 

--------------------------------------------------------------------------------

# 