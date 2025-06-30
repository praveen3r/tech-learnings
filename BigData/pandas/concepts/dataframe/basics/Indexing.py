# custom index

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df)

--------------------------------------------------------------------------------

# access rows by name

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df.loc['Sachin']) 

--------------------------------------------------------------------------------

# reset index

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df.loc['Sachin']) 

df.reset_index(inplace=True)

--------------------------------------------------------------------------------

# Accessing Columns

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35],
    'IPL': ['MI','DD','KKR']
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df['Age'])         # Single column
print(df[['IPL', 'Age']])  # Multiple columns

--------------------------------------------------------------------------------

# MultiIndex

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35],
    'IPL': ['MI','DD','KKR']
}

df = pd.DataFrame(data)

df.set_index(['Name', 'IPL'], inplace=True)
print(df)

