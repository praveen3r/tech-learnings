# Add single row

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag'],
    'Age': [25, 30]
})

df.loc[len(df)] = ['Ganguly', 35]  # Append at last index

print(df)

---------------------------------------------------------------------------------------

# Add multiple rows using pd.concat()

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag'],
    'Age': [25, 30]
})

new_rows = pd.DataFrame([
    {'Name': 'Ganguly', 'Age': 35},
    {'Name': 'Dravid', 'Age': 32}
])

df = pd.concat([df, new_rows], ignore_index=True)

print(df)

---------------------------------------------------------------------------------------

# Using DataFrame.loc[] repeatedly in a loop

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag'],
    'Age': [25, 30]
})

for name, age in [('Laxman', 34), ('Dhoni', 31)]:
    df.loc[len(df)] = [name, age]

print(df)

---------------------------------------------------------------------------------------

# Add multiple rows using a loop

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag'],
    'Age': [25, 30]
})

new_data = [('Ganguly', 35), ('Dravid', 32), ('Dhoni', 28)]

for name, age in new_data:
    df.loc[len(df)] = [name, age]

print(df)

---------------------------------------------------------------------------------------

# Drop rows by index number

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df = df.drop([1, 3])  

print(df)

---------------------------------------------------------------------------------------

# Drop rows by index number by modifying DF

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df.drop([1, 3], inplace=True)

print(df)

---------------------------------------------------------------------------------------

# Drop rows by condition

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df = df[df['Age'] > 30]  # Keeps only rows where Age > 30

print(df)

---------------------------------------------------------------------------------------

# Drop duplicate rows

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid','Sachin'],
    'Age': [25, 30, 35, 32, 25]
})

df.drop_duplicates(inplace=True)

print(df)

---------------------------------------------------------------------------------------

# Drop rows with missing values (NaN)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df.dropna(inplace=True)

print(df)

---------------------------------------------------------------------------------------

# Reset index after dropping

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid'],
    'Age': [25, 30, 35, 32]
})

df.reset_index(drop=True, inplace=True)

print(df)

---------------------------------------------------------------------------------------

# Drop rows based on multiple conditions

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

# Drop rows where Age < 30 AND Name == 'Sachin'

df = df[~((df['Age'] < 30) & (df['Name'] == 'Sachin'))] 

print(df)

---------------------------------------------------------------------------------------

# Drop rows based on label (index name)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

df.set_index('Name', inplace=True)
df = df.drop(['Sachin'])  # Drops all rows with index 'Sachin'

df.reset_index(inplace=True)

print(df)

---------------------------------------------------------------------------------------

# Drop all rows with a specific value

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

df = df[df['Name'] != 'Dravid'] # Drop rows where Name == 'Dravid'

print(df)

---------------------------------------------------------------------------------------

# Drop duplicate rows (same Name, Age, etc.)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})


df = df.drop_duplicates()

print(df)

---------------------------------------------------------------------------------------

# Drop rows where Age > 30 OR Name starts with 'S'

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

df = df[~((df['Age'] > 30) | (df['Name'].str.startswith('S')))]

print(df)

---------------------------------------------------------------------------------------

# Drop rows where Name matches regex

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

df = df[~df['Name'].str.contains('^S', regex=True)]

print(df)

---------------------------------------------------------------------------------------

# Drop rows where Name == 'Sehwag' and Age == 28

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

df = df[~((df['Name'] == 'Sehwag') & (df['Age'] == 28))]

print(df)

---------------------------------------------------------------------------------------

# Drop all rows where Name is in a list

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly', 'Dravid', 'Sachin'],
    'Age': [25, 30, 35, 32, 25],
    'Country': ['India', 'India', 'India', 'India', 'India']
})

names_to_drop = ['Dravid', 'Sehwag']
df = df[~df['Name'].isin(names_to_drop)]

print(df)

---------------------------------------------------------------------------------------