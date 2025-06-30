# Row Slice by index position (iloc)

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.iloc[1:4])

----------------------------------------------------------------------

# Row Slice by label (loc)

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df.loc['Sachin':'Ganguly']) 

----------------------------------------------------------------------

# Column Slicing - Single Column

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df['Age'])

----------------------------------------------------------------------

# Column Slicing - Multiple Column

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df['Age','Name'])

----------------------------------------------------------------------

# Row + Column Slicing

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

print(df.iloc[1:4, 0:2])

----------------------------------------------------------------------

# Row + Column Slicing using loc by labels

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}

df = pd.DataFrame(data)

df.set_index('Name', inplace=True)

print(df.loc['Sachin':'Ganguly', ['Age']])
