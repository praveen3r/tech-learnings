# Rename all columns at once

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = ['PlayerName', 'PlayerAge']

print(df)

------------------------------------------------------------------------------

# Rename specific column using rename

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.rename(columns={'Name': 'PlayerName', 'Age': 'PlayerAge'}, inplace=True)

print(df)

------------------------------------------------------------------------------

# Rename with a loop or function

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = [col.lower() for col in df.columns]

print(df)

------------------------------------------------------------------------------

# Reset column names to original manually:

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = [col.lower() for col in df.columns]

print(df)

df.columns = ['Name', 'Age']

------------------------------------------------------------------------------

# using .str accessor 

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = df.columns.str.lower()

print(df)

------------------------------------------------------------------------------

# replace space with underscore in column using .str

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = df.columns.str.replace(' ', '_')

print(df)

------------------------------------------------------------------------------

# Chain multiple operations  using .str

import pandas as pd

# Original DataFrame
data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.columns = df.columns.str.strip().str.lower().str.replace(' ', '_')

print(df)

