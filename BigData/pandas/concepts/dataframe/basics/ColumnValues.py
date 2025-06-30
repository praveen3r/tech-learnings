# Update with a fixed value

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Age'] = 40

print(df)

--------------------------------------------------------------------------------

# Update with a list of new values

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Age'] = [26, 31, 36]

print(df)

--------------------------------------------------------------------------------

# Update with a condition

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Name'] == 'Shewag', 'Age'] = 33

print(df)

--------------------------------------------------------------------------------

# Update a single cell

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[0, 'Age'] = 26

print(df)

--------------------------------------------------------------------------------

# Update an entire column

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Name'] == 'Ganguly', 'Age'] = 40

print(df)

--------------------------------------------------------------------------------

# Update multiple columns conditionally

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Age'] > 30, ['Name', 'Age']] = ['Senior', 999]

print(df)

--------------------------------------------------------------------------------

# Update a single cell

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.iloc[0, 1] = 26

print(df)

--------------------------------------------------------------------------------

# Update a full column

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.iloc[:, 1] = [26, 31, 36]

print(df)

--------------------------------------------------------------------------------

# Update a full row

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.iloc[1] = ['Sehwag Updated', 32] 

print(df)

--------------------------------------------------------------------------------

# Update a range

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.iloc[0:2, 1] = [50, 60]

print(df)

--------------------------------------------------------------------------------

# Update with a fixed value

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df = pd.DataFrame(data)

df['Age'] = 40

print(df)

--------------------------------------------------------------------------------

#  Update values based on string condition

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Name'].str.contains('a'), 'Age'] = 100

print(df)

--------------------------------------------------------------------------------

# Update Name where Age is above 30

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Age'] > 30, 'Name'] = 'Senior Player'

print(df)

--------------------------------------------------------------------------------

# Update multiple columns with filter

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df.loc[df['Name'].str.startswith('S'), ['Name', 'Age']] = ['Legend', 99]

print(df)

--------------------------------------------------------------------------------

# Use str.replace() to update name format

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Name'] = df['Name'].str.replace('a', '@', regex=False)

print(df)

--------------------------------------------------------------------------------

# Update using a function

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Age'] = df['Age'].apply(lambda x: x + 1)

print(df)

--------------------------------------------------------------------------------

# Update based on another column (add a new column)

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['AgeCategory'] = df['Age'].apply(lambda x: 'Senior' if x > 30 else 'Junior')

print(df)

----------------------------------------------------------------------------------------------------------------------------------------------------------------

# map() — Element-wise operation on a Series (single column)
# Use map() when you want to transform values in a single column.

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Name'] = df['Name'].map(lambda x: 'Mr. ' + x)
print(df)

print(df)
--------------------------------------------------------------------------------

# using a dictionary

import pandas as pd

data = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
}
df = pd.DataFrame(data)

df['Name'] = df['Name'].map({'Sachin': 'SRT', 'Shewag': 'Viru'})

print(df)
--------------------------------------------------------------------------------

# applymap() — Element-wise operation on all cells in a DataFrame

import pandas as pd

data = {
    'A': [1, 2],
    'B': [3, 4]
}

df = pd.DataFrame(data)

df = df.applymap(lambda x: x * 10)

print(df)
--------------------------------------------------------------------------------

# replace() — Replace values in Series or DataFrame
# single value

import pandas as pd

data = {
    'City': ['Delhi', 'Mumbai', 'Chennai']
}

df = pd.DataFrame(data)

df['City'] = df['City'].replace('Mumbai', 'Bombay')

print(df)
--------------------------------------------------------------------------------

# replace() — Replace values in Series or DataFrame
# multipe value

import pandas as pd

data = {
    'City': ['Delhi', 'Mumbai', 'Chennai']
}

df = pd.DataFrame(data)

df['City'] = df['City'].replace({'Delhi': 'DL', 'Chennai': 'Madras'})

print(df)

---------------------------------------------------------------------------------------

Method	     Works On	          Operates On	            Use Case
---------------------------------------------------------------------------------------
map()	       Series (1 column)	Each element (cell)	    Element-wise transformation of a Series
apply()	       Series/DataFrame	    Series (or row/col)	    Apply function across a Series or axis of DataFrame
applymap()	   DataFrame	        Each element (cell)	    Element-wise operation on all DataFrame cells
replace()	   Series / DataFrame	Values (match/replace)	Replace values exactly, with dict, list, or regex
