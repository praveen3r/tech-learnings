import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df)

--------------------------------------------------------------------------------

# Access a Single Column

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df['Name'])
print(df.Name)

--------------------------------------------------------------------------------

# Access Multiple Columns

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df[['Name', 'City']])

--------------------------------------------------------------------------------

# Access Rows by Index 

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.loc[0])



--------------------------------------------------------------------------------

# Access Specific Cell

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.at[1, 'Age']) 

--------------------------------------------------------------------------------

# Return row 0 and 1

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.loc[[0, 1]])
--------------------------------------------------------------------------------

# Locate Named Indexes

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.loc["Age"])
--------------------------------------------------------------------------------

# View top 5 rows 

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.head(5))
--------------------------------------------------------------------------------

# View bottom 5 rows

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.tail(5))
--------------------------------------------------------------------------------

# Type

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(type(df))
print(type(df['Name'])) # type of a column
print(df.dtypes) # datatype of all columns
--------------------------------------------------------------------------------

# summary statistics of DataFrame

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.describe())
--------------------------------------------------------------------------------

# Access Multiple Columns
--------------------------------------------------------------------------------

# Access Multiple Columns




